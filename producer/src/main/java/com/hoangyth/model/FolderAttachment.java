package com.hoangyth.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

    @Entity
    @Table(name = "folder_attachment")
    @Data
    public class FolderAttachment {
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "ID", nullable = false, length = 100)
        private String id;

        private String folderId;

        private String attachmentId;
}
