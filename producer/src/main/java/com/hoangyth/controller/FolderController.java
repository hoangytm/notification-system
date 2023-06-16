package com.hoangyth.controller;

import com.hoangyth.dto.FolderDto;
import com.hoangyth.dto.FolderSearch;
import com.hoangyth.model.Folder;
import com.hoangyth.service.FolderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@RequestMapping("folders")
@RestController
@AllArgsConstructor
public class FolderController {
    private final FolderService folderService;

    @PostMapping
    public String create(@RequestBody Folder folder) {
        return folderService.create(folder);
    }

    @PutMapping
    public String update(@RequestBody com.hoangyth.model.Folder folder) {
        return folderService.update(folder);
    }

    @DeleteMapping("/{folderId}")
    public void delete(@PathVariable String folderId,
                       HttpServletResponse response) {
        folderService.delete(folderId);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @GetMapping("/{folderId}")
    public Folder getFolderById(@PathVariable @NotNull String folderId) {
        return folderService.getFolderById(folderId);
    }

    @GetMapping("/{parentId}/children")
    public FolderDto getChildren(@PathVariable @NotNull String parentId) {
        return folderService.getChildren(parentId);
    }

    @GetMapping("/search")
    public FolderDto search(FolderSearch folderSearch) {
        return folderService.search(folderSearch);
    }

}
