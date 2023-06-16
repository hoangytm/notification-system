package com.hoangyth.controller;

import com.hoangyth.model.FolderPermissionPK;
import com.hoangyth.service.PermissionService;
import com.hoangyth.utils.PermissionType;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("folder-permission")
@RestController
@AllArgsConstructor
public class FolderPermissionController {
    private final PermissionService permissionService;

    @PostMapping
    public FolderPermissionPK createFolderPermission(@RequestBody FolderPermissionPK folderPermissionPK) {
        return permissionService.create(folderPermissionPK);
    }

    @PutMapping
    public FolderPermissionPK update(@RequestBody FolderPermissionPK folderPermissionPK) {
        return permissionService.update(folderPermissionPK);
    }

    @DeleteMapping
    public FolderPermissionPK delete(@RequestParam String userId,
                                     @RequestParam PermissionType permissionType,
                                     @RequestParam String folderId) {
        FolderPermissionPK folderPermissionPK = new FolderPermissionPK(userId, permissionType, folderId);
        return permissionService.delete(folderPermissionPK);
    }

}
