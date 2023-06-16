package com.hoangyth.dto;

import com.hoangyth.model.Attachment;
import com.hoangyth.model.Folder;
import lombok.Data;

import java.util.List;
@Data
public class FolderDto {

    private String folderId;

    private String folderName;

    private List<Folder> folders;

    private List<Attachment> attachments;

}
