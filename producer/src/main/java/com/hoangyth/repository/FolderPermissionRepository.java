package com.hoangyth.repository;

import com.hoangyth.model.FolderPermission;
import com.hoangyth.model.FolderPermissionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FolderPermissionRepository extends JpaRepository<FolderPermission, FolderPermissionPK> {
    Optional<FolderPermission> findAllByFolderIdAndUserId(String folderId, String userId);

    List<FolderPermission> findAllByFolderId(String folderId);
}
