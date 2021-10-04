package com.example.coderunner.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.coderunner.lab.model.Lab;
import com.example.coderunner.lab.model.LabQuestion;
import com.example.coderunner.lab.model.Procedure;
import com.example.coderunner.lab.repository.LabQuestionRepository;
import com.example.coderunner.lab.repository.ProcedureRepository;
import com.example.coderunner.message.ResponseMessage;
import com.example.coderunner.model.FileInfo;
import com.example.coderunner.service.FilesStorageService;
import com.example.coderunner.service.JavaRunnerService;
import com.example.injector.java.Rewrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


@RestController
@CrossOrigin("http://localhost:3000")
public class FilesController {

    @Autowired
    FilesStorageService storageService;

    @Autowired
    LabQuestionRepository labRepo;

    @Autowired
    ProcedureRepository procedures;

    @PostMapping("/upload")
    public List uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("user_id") long user_id,
            @RequestParam("lab_id") long lab_id) {
        System.out.println("params " +user_id + " " + lab_id);
        ArrayList messages = new ArrayList<String>();
        try {
            String path = storageService.save(file);
            Rewrite.class_name(path);
            JavaRunnerService jrs = new JavaRunnerService(path);
            LabQuestion l = labRepo.findById(lab_id).get();
            Procedure p = procedures.findById(l.getLab_id()).get();
            messages.add(jrs.run(l, p));

            return messages;
        } catch (Exception e) {
            messages.add("Could not upload the file: " + file.getOriginalFilename() + "!");
            return messages;
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}