package com.hoangyth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "folder_permission")
@Data
public class FolderPermission implements Serializable {
    @EmbeddedId
    private FolderPermissionPK id;

    @ManyToOne
    @JoinColumn(name = "folderId", nullable = false, insertable = false, updatable = false)
    private Folder folder;

    @ManyToOne
    @JoinColumn(name = "permissionId", nullable = false, insertable = false, updatable = false)
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false, insertable = false, updatable = false)
    private User user;

}
