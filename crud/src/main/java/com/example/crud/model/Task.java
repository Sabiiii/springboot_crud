package com.example.crud.model;

import com.example.crud.model.Kontaktperson;
import com.example.crud.model.Taetigkeit;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@ToString(exclude = {"taetigkeiten"})
@Data
@RequiredArgsConstructor
@Entity(name = "Task")
@Table(name = "task")
public class Task implements Serializable {


    // Defining already the actual schema in the db
    @Column(name = "taskid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date ErfasstAm;

    @NotBlank(message = "Name is required")
    @Column(name = "stichwort")
    private String stichwort;

    @Column(name = "beschreibung")
    private String beschreibung;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fertigAm")
    private LocalDate fertigAm;

    @Column(name = "priority")
    private Priority priority;

    public static enum Priority {
        A, B, C
    }

    @Column(name = "status")
    private Status status;

    public static enum Status {
        NichtBegonnen, inBearbeitung, WartenAufAnderen, Zurueckgestellt, Erledigt
    }

    @Column(name = "Kategorie")
    private Kategorie kategorie;

    public static enum Kategorie {
        Beruf, Privat
    }

    @PrePersist
    void erfasstAm() {
        this.ErfasstAm = new Date();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Kontaktperson kontaktperson;


    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL,orphanRemoval = true)
    List<Taetigkeit> taetigkeiten = new ArrayList<>();


}

