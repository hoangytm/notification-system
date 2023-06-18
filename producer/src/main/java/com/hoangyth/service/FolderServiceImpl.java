package com.hoangyth.service;

import com.hoangyth.dto.FolderDto;
import com.hoangyth.dto.FolderSearch;
import com.hoangyth.model.*;
import com.hoangyth.repository.FolderPermissionRepository;
import com.hoangyth.repository.FolderRepository;
import com.hoangyth.utils.AccessoryType;
import com.hoangyth.utils.MockToken;
import com.hoangyth.utils.PermissionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.hoangyth.utils.FolderConstant.*;

@Service
@AllArgsConstructor
@Transactional
public class FolderServiceImpl implements FolderService {
    private final FolderRepository folderRepository;
    private final FolderPermissionRepository folderPermissionRepository;
    private final PermissionService permissionService;

    @Override
    public String create(Folder folder) {
        if (ROOT.equals(folder.getParentId())) {
            folder.setParentPath(ROOT_PATH);
        } else {
            Folder parent = folderRepository.findById(folder.getParentId())
                    .orElseThrow(() -> new RuntimeException(" error when creating path for this folder"));
            folder.setParentPath(parent.getParentPath() + "/" + parent.getId());
        }
        folder.setIsVisible(VISIBLE);
        Folder returnedFolder = folderRepository.save(folder);
        // the folder creator have the write permission as default
        permissionService.create(new FolderPermissionPK(MockToken.getAdmin().getId()
                , PermissionType.WRITE,
                folder.getId()));

        return returnedFolder.getId();
    }

    @Override
    public String update(Folder folderDto) {
        folderRepository.findById(folderDto.getId()).orElseThrow(() -> new RuntimeException("not found folder"));
        Folder returnedFolder = folderRepository.save(folderDto);
        return returnedFolder.getId();
    }

    @Override
    public void delete(String folderId) {
        if (isWritePermission()) {
            Folder folder = folderRepository.findById(folderId)
                    .orElseThrow(() -> new RuntimeException("not found folder"));
            deleteRelatedItems(folderId);
            folderRepository.delete(folder);
            List<Folder> folders = folderRepository.findAllByParentId(folderId);
            folders.forEach(item -> delete(item.getId()));

        } else {
            throw new RuntimeException(" you dont have the permission to delete this folder! ");
        }

    }

    private void deleteRelatedItems(String folderId) {
        List<FolderPermission> folderPermissions = folderPermissionRepository.findAllByFolderId(folderId);
        folderPermissionRepository.deleteAllInBatch(folderPermissions);
    }

    private boolean isWritePermission() {
        return true;
    }

    @Override
    public Folder getFolderById(String folderId) {
        return folderRepository.findById(folderId)
                .orElseThrow(() -> new RuntimeException("not found folder"));
    }

    @Override
    public FolderDto getChildren(String parentId) {
        Folder folder = folderRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("not found folder"));
        FolderDto folderDto = new FolderDto();
        folderDto.setFolderId(folder.getId());
        folderDto.setFolderName(folder.getName());
        if (hasPermission(parentId)) {
            List<Folder> childrenFolder = folderRepository.findAllByParentId(parentId);

            folderDto.setFolders(childrenFolder);
        } else {
            throw new RuntimeException(" do not have permission for this folder!");
        }

        return folderDto;
    }

    private boolean hasPermission(String parentId) {
        return true;
    }

    @Override
    public FolderDto search(FolderSearch folderSearch) {

        Optional<Permission> highestPermission = permissionService
                .getHighestPermission(MockToken.getAdmin(), folderSearch.getFolderId());
        if (highestPermission.isPresent()) {
            folderRepository.search(MockToken.getAdmin(), folderSearch);
            FolderDto folderDto = new FolderDto();
            if(folderSearch.getAccessoryTypes().contains(AccessoryType.ATTACHMENT)){
                folderDto.setAttachments(findAttachmentByParent(folderSearch.getKeyWord(),folderSearch.getFolderId()));
            }
            if(folderSearch.getAccessoryTypes().contains(AccessoryType.FOLDER)){
                folderDto.setFolders(findFolderByParent(folderSearch.getKeyWord(),folderSearch.getFolderId()));
            }
            return folderDto;
        }
        return null;
    }

    private List<Attachment> findAttachmentByParent(String attachmentName, String parentId) {
        Attachment attachment = new Attachment();
        return Collections.singletonList(attachment);
    }

    private List<Folder> findFolderByParent(String attachmentName, String parentId) {
        return folderRepository.findFolderByParent(attachmentName, parentId);

    }

}
