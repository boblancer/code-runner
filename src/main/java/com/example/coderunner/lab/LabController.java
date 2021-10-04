package com.example.coderunner.lab;

import com.example.coderunner.lab.model.Lab;
import com.example.coderunner.lab.model.LabQuestion;
import com.example.coderunner.lab.repository.LabRepository;
import com.example.coderunner.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

//@Controller
//@CrossOrigin("http://localhost:3000")
//public class LabController {
//
//    @Autowired
//    LabRepository labRepo;
//
//    @PostMapping("/lab/create")
//    public ResponseEntity<ResponseMessage> LabCreate(
//            @RequestParam("user_id") String id,
//            @RequestParam("lab_name") String name,
//            @RequestParam("description") String markdown)
//    {
//        Lab lab = new Lab(123L);
//        List questions = new ArrayList<LabQuestion>();
//        questions.add(new LabQuestion("question 1", 123L));
//        lab.setQuestions(questions);
//        labRepo.save(lab);
//        System.out.println(lab);
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(new ResponseMessage(lab.toString()));
//    }
//
//    @PostMapping("/lab/question/add")
//    public ResponseEntity<ResponseMessage> AddQuestion(
//            @RequestParam("user_id") String id,
//            @RequestParam("lab_id") Long lab_id,
//            @RequestParam("description") String markdown)
//    {
//        Lab lab = new Lab(123L);
//        List questions = new ArrayList<LabQuestion>();
//        questions.add(new LabQuestion("question 1", 123L));
//        lab.setQuestions(questions);
//        labRepo.save(lab);
//        System.out.println(lab);
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(new ResponseMessage(lab.toString()));
//    }
//}