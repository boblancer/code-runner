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

public class Workspace {

    private @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id; // will be set when persisting

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "class_id")
    private List<Lab> labs = new ArrayList<>();
    private Long owner_id;
    private String name;

    private String description;

    public Workspace(Long owner_id, String name, String description){
        this.owner_id = owner_id;
        this.description = description;
        this.name = name;
    }
}
