package com.example.crud.dao;

import com.example.crud.model.Task;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
List<Task> findByFertigAm(Date fertigAm, Sort sort);


    //JPA Repository actually extends crud Repository

}
