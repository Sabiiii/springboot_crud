package com.example.crud.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Data
@Entity
public class Taetigkeit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long taetigkeitsid;


    @ManyToOne
    @JoinColumn(name = "mitarbeiterid")
    Mitarbeiter mitarbeiter;


    @ManyToOne
    @JoinColumn(name = "taskid")
    Task task;

    @NotBlank(message="Beschreibung is required")
    String beschreibung;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date endeTermin;



}
