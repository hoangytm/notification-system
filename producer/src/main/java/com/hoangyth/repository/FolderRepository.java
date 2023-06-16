package com.hoangyth.repository;

import com.hoangyth.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder, String>, CustomFolderRepository {
    List<Folder> findAllByParentId(String parentId);
}
