package com.hoangyth.dto;

import com.hoangyth.utils.AccessoryType;
import com.hoangyth.utils.PermissionType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class FolderSearch {
    @NotNull
    private String folderId;
    private String folderName;
    private List<AccessoryType> accessoryTypes;
    private List<PermissionType> permissionTypes;

}
