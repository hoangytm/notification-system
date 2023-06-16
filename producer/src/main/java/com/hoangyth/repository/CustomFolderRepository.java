package com.hoangyth.repository;

import com.hoangyth.dto.FolderDto;
import com.hoangyth.dto.FolderSearch;
import com.hoangyth.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomFolderRepository {
    List<FolderDto> search(User user, FolderSearch folderSearch);
}
