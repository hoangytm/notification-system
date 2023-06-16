package com.hoangyth.model;

import com.hoangyth.utils.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
@EqualsAndHashCode
public class FolderPermissionPK implements Serializable {
    @Column(insertable = false, nullable = false, precision = 9)
    private String userId;

    @Column(insertable = false, nullable = false, precision = 9)
    @Enumerated(EnumType.ORDINAL)
    private PermissionType permissionType;

    @Column(insertable = false, nullable = false, precision = 9)
    private String folderId;

}