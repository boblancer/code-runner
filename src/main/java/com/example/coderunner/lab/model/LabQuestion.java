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

public class LabQuestion {

    private @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id; // will be set when persisting

    private String content;
    private Long lab_id;

    public LabQuestion(String content, Long lab_id){
        this.content = content;
        this.lab_id = lab_id;
    }

}