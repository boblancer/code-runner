package com.example.coderunner.utils;

public class HashCode {
    public static String hash(String filename){
        long timestamp = System.currentTimeMillis();
        return filename + timestamp;
    }
}
