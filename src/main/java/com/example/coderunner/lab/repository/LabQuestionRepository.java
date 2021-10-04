package com.example.coderunner.lab.repository;

import com.example.coderunner.lab.model.LabQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabQuestionRepository extends CrudRepository<LabQuestion, Long> {

}