package com.example.crud.dao;

import com.example.crud.model.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;

public interface MitarbeiterRepository extends CrudRepository<Mitarbeiter, Long> {
}
