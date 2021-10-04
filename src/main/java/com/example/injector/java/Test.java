package com.example.injector.java;

import com.example.coderunner.lab.model.LabQuestion;
import com.example.coderunner.lab.model.Procedure;
import com.example.coderunner.lab.repository.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class Test {
    @Autowired
    ProcedureRepository procedure;

    public ArrayList<String> inject(Object o, LabQuestion l, Procedure p){
        procedure.findById(l.getLab_id());
        try {
            Method method = o.getClass().getMethod("square", int.class);
            String result = null;
            System.out.println("Injector result = " + result);
            return new ArrayList<String>(Arrays.asList(result));
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<String>(Arrays.asList("Error: " + e));
        }

    }
}
