package com.hoangyth.service;

import com.hoangyth.model.*;
import com.hoangyth.repository.FolderPermissionRepository;
import com.hoangyth.repository.FolderRepository;
import com.hoangyth.utils.MockToken;
import com.hoangyth.utils.PermissionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PermissionServiceImpl implements PermissionService {
    private final FolderPermissionRepository folderPermissionRepository;
    private final FolderRepository folderRepository;

    @Override
    public FolderPermissionPK create(FolderPermissionPK folderPermissionPK) {
        FolderPermission folderPermission = new FolderPermission();
        folderPermission.setId(folderPermissionPK);

        folderPermissionRepository.save(folderPermission);
        return folderPermissionPK;
    }

    @Override
    public Optional<FolderPermission> findAllByFolderIdAndUserId(String folderId, String userId) {
        return folderPermissionRepository.findAllByFolderIdAndUserId(folderId, userId);
    }

    @Override
    public FolderPermissionPK update(FolderPermissionPK folderPermissionPK) {
        FolderPermission folderPermission = folderPermissionRepository
                .findAllByFolderIdAndUserId(folderPermissionPK.getFolderId(), folderPermissionPK.getUserId()).
                        orElseThrow(() -> new RuntimeException(" not found permission for this folder"));
        folderPermission.setId(folderPermissionPK);
        folderPermissionRepository.save(folderPermission);
        return folderPermissionPK;
    }

    @Override
    public FolderPermissionPK delete(FolderPermissionPK folderPermissionPK) {
        folderPermissionRepository.deleteById(folderPermissionPK);
        return folderPermissionPK;
    }

    @Override
    public Optional<Permission> getHighestPermission(User user, String folderId) {
        Permission highestPermission = null;
        Optional<FolderPermission> folderPermission = findAllByFolderIdAndUserId(folderId, MockToken.getAdmin().getId());
        if (folderPermission.isPresent()) {
            if (folderPermission.get().getId().getPermissionType() == PermissionType.WRITE) {
                return Optional.of(folderPermission.get().getPermission());
            } else {
                highestPermission = folderPermission.get().getPermission();
            }

        }
        Optional<Folder> folder = folderRepository.findById(folderId);
        if (folder.isPresent()) {
            String[] parentIds = folder.get().getParentPath().split("/");
            List<Optional<FolderPermission>> permissions = Arrays.stream(parentIds)
                    .map(item -> findAllByFolderIdAndUserId(item, MockToken.getAdmin().getId()))
                    .collect(Collectors.toList());
            for (Optional<FolderPermission> item : permissions) {
                if (item.isPresent() &&
                        (highestPermission == null ||
                                highestPermission.getPermissionType().getValue() < item.get().getPermission().getPermissionType().getValue())) {
                    highestPermission = item.get().getPermission();
                }

            }


        }
        return Optional.ofNullable(highestPermission);
    }
}
