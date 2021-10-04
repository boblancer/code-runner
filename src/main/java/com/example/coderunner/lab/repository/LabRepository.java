package com.example.coderunner.lab.repository;

import com.example.coderunner.lab.model.Lab;
import com.example.coderunner.lab.model.LabQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LabRepository extends CrudRepository<Lab, Long> {

}