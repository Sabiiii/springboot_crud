package com.example.crud.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Kontaktperson")
public class Kontaktperson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personid")
    private long personid;

    @NotBlank(message="Spitzname is required")
    @Column(name = "spitzname")
    private String spitzname;

    @NotBlank(message="Nachname is required")
    @Column(name = "nachname")
    private String nachname;

    @NotBlank(message="Vorname is required")
    @Column(name = "vorname")
    private String vorname;

    @Pattern(regexp = "^[0-9]*$", message = "Must be a phone Number")
    @Column(name = "telefon")
    private String telefon;

    @Email
    @Column(name = "email")
    private String email;


}
