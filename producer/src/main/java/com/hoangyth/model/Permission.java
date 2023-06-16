package com.hoangyth.model;

import com.hoangyth.utils.PermissionType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PERMISSION")
@Data
public class Permission {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false, length = 100)
    private String id;

    private String name;

    @Column(insertable = false, nullable = false, precision = 9)
    @Enumerated(EnumType.ORDINAL)
    private PermissionType permissionType;
}
