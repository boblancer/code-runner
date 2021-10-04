package com.example.coderunner.lab.model;

import lombok.*;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Lab {

    private @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id; // will be set when persisting

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lab_id")
    private List<LabQuestion> questions = new ArrayList<>();
    private Long workspace_id;

    @OneToOne
    private Procedure procedure;

    public Lab(Long class_id){
        this.workspace_id = class_id;
    }
}
