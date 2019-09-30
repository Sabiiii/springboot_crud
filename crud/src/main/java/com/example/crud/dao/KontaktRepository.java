package com.example.crud.dao;

import com.example.crud.model.Kontaktperson;
import org.springframework.data.repository.CrudRepository;

public interface KontaktRepository extends CrudRepository<Kontaktperson, Long> {
}
