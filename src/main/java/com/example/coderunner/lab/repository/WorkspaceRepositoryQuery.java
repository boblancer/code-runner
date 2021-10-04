package com.example.coderunner.lab.repository;

import com.example.coderunner.lab.model.Lab;
import com.example.coderunner.lab.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkspaceRepositoryQuery extends JpaRepository<Workspace, Long> {
    @Query(value = "SELECT * FROM workspace WHERE owner_id = ?1", nativeQuery = true)
    List<Workspace> findByOwnerId(Long owner_id);

}

