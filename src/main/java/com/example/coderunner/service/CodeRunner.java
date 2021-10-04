package com.example.coderunner.service;

import com.example.coderunner.lab.model.LabQuestion;
import com.example.coderunner.message.ResponseMessage;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public interface CodeRunner {
    public ArrayList<String> run(LabQuestion l) throws ClassNotFoundException, NoSuchMethodException, MalformedURLException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
