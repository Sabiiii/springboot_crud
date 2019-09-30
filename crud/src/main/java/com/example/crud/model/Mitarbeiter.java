package com.example.crud.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = {"taetigkeiten"})
@Data
@Entity(name = "Mitarbeiter")
@Table(name="mitarbeiter")
@RequiredArgsConstructor
public class Mitarbeiter implements Serializable {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "mitarbeiterid")
        private long mitarbeiterid;

        @NotBlank(message="Name is required")
        @Column(name = "spitzname")
        private String spitzname;

        @NotBlank(message="Name is required")
        @Column(name = "nachname")
        private String nachname;

        @NotBlank(message="Name is required")
        @Column(name = "vorname")
        private String vorname;

        @Pattern(regexp = "^[0-9]*$", message = "Must be a phone Number")
        @Column(name = "telefon")
        private String telefon;

        @Email
        @Column(name = "email")
        private String email;


        @OneToMany(mappedBy = "mitarbeiter",cascade = CascadeType.ALL, orphanRemoval = true)
        List<Taetigkeit> taetigkeiten = new ArrayList<>();


}


