package com.hoangyth.repository;

import com.hoangyth.dto.FolderDto;
import com.hoangyth.dto.FolderSearch;
import com.hoangyth.model.Folder;
import com.hoangyth.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomFolderRepositoryImpl implements CustomFolderRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<FolderDto> search(User user, FolderSearch folderSearch) {

        return null;
    }

    private List<Folder> findTreeFolder() {
        return null;
    }
}
