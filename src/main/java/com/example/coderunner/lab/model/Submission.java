package com.example.coderunner.lab.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Submission {

    private @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id; // will be set when persisting

    private String json_result;
    private String timestamp;


    public Submission(String json, String timestamp){

        this.json_result = json;
        this.timestamp = timestamp;
    }
}
