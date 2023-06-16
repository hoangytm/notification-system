package com.hoangyth.service;


import com.hoangyth.model.FolderPermission;
import com.hoangyth.model.FolderPermissionPK;
import com.hoangyth.model.Permission;
import com.hoangyth.model.User;

import java.util.Optional;

public interface PermissionService {
    FolderPermissionPK create(FolderPermissionPK folderPermissionPK);

    FolderPermissionPK delete(FolderPermissionPK folderPermissionPK);

    FolderPermissionPK update(FolderPermissionPK folderPermissionPK);

    Optional<FolderPermission> findAllByFolderIdAndUserId(String folderId, String userId);

    Optional<Permission> getHighestPermission(User user, String folderId);


}
