package com.example.coderunner.lab.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Procedure {

    private @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id; // will be set when persisting

    private String json_configuration;

    public Procedure(String json){
        this.json_configuration = json;
    }
}
