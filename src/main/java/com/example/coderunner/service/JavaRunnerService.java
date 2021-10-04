package com.example.coderunner.service;

import com.example.coderunner.lab.model.LabQuestion;
import com.example.coderunner.lab.model.Procedure;
import com.example.coderunner.message.ResponseMessage;
import com.example.injector.java.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class JavaRunnerService implements CodeRunner  {
    private final Path root = Paths.get("src/main/java/com/example/gen");
    private String path;
    public JavaRunnerService(String path){
        this.path = path;
    }

    public ArrayList<String> run(LabQuestion l, Procedure p) throws ClassNotFoundException, NoSuchMethodException, MalformedURLException, IllegalAccessException, InvocationTargetException, InstantiationException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, this.path);
//            Path filename = this.root.resolve(this.path);
        String name = path.split(Pattern.quote("\\"))
                [path.split(Pattern.quote("\\")).length - 1]
                .split("\\.")[0] ;
        try {
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toUri().toURL()});
            Class<?> cls = Class.forName( name, true, classLoader);

            Object instance = cls.getDeclaredConstructor().newInstance();

            System.out.println(instance);
            Test t = new Test();
            return t.inject(new Object(), l, p);
        } catch (Exception e){
            System.out.println(e);
            return new ArrayList<String>(Arrays.asList("Error: " + e + "from running service"));
        }
    }


    @Override
    public ArrayList<String> run(LabQuestion l) throws ClassNotFoundException, NoSuchMethodException, MalformedURLException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return null;
    }
}
