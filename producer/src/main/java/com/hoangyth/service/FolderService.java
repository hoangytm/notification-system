package com.hoangyth.service;


import com.hoangyth.dto.FolderDto;
import com.hoangyth.dto.FolderSearch;
import com.hoangyth.model.Folder;

public interface FolderService {

    Folder getFolderById(String folderId);

    String create(Folder folder);

    String update(Folder folder);

    void delete(String folderId);

    FolderDto getChildren(String parentId);

    FolderDto search(FolderSearch folderSearch);
}
