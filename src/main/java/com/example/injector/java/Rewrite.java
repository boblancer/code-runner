package com.example.injector.java;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rewrite {
    static public boolean class_name(String file_path) throws IOException {
        File fileToBeModified = new File(file_path);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        String old_class_name = "";

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                if (Pattern.matches(".*public class.*", line)){
                    old_class_name = line.split("\\s+")[2];
                }

                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(old_class_name,  fileToBeModified.getName().split("\\.")[0]);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

//            writer.write(newContent);
            writer.write(newContent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return true;
    }
}
