package com.example.coderunner.lab.repository;

import com.example.coderunner.lab.model.LabQuestion;
import com.example.coderunner.lab.model.Workspace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkspaceRepository extends CrudRepository<Workspace, Long> {

}