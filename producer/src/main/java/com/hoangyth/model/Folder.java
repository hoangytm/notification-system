package com.hoangyth.model;

import com.hoangyth.utils.FolderType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "FOLDER")
@Data
public class Folder {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false, length = 100)
    private String id;

    @Column(name = "PARENT_ID", length = 2000)
    private String parentId;

    @Column(name = "PARENT_PATH", length = 2000)
    private String parentPath;

    @Column(name = "name", length = 2000)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "folder_type")
    private FolderType folderType;

    @Column(name = "create_date", length = 2000)
    private Date createDate;

    @Column(name = "creator_id", length = 2000)
    private String creatorId;

    @Column(name = "is_visible")
    private Integer isVisible;

}
