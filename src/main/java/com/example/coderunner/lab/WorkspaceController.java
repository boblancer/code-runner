package com.example.coderunner.lab;

import com.example.coderunner.lab.model.Lab;
import com.example.coderunner.lab.model.LabQuestion;
import com.example.coderunner.lab.model.Workspace;
import com.example.coderunner.lab.repository.LabRepository;
import com.example.coderunner.lab.repository.WorkspaceRepository;
import com.example.coderunner.lab.repository.WorkspaceRepositoryQuery;
import com.example.coderunner.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class WorkspaceController {
    @Autowired
    WorkspaceRepositoryQuery repo;

    @GetMapping("/workspace/all")
    public List All(
            @RequestParam("user_id") Long id) {
        System.out.println(id);
        List<Workspace> ws = repo.findByOwnerId(id);
        System.out.println(ws);
        return ws;
    }

    @GetMapping("/admin/workspace/all")
    public List AdminAll(
            @RequestParam("user_id") Long id) {
        List<Workspace> ws = repo.findByOwnerId(id);
        return ws;
    }
}