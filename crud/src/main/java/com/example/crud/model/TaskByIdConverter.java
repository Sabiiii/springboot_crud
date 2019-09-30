package com.example.crud.model;

import com.example.crud.dao.TaskRepository;
import com.example.crud.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TaskByIdConverter implements Converter<Long, Task> {


    private TaskRepository taskRepository;

    @Autowired
    public TaskByIdConverter(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskByIdConverter() {

    }

    @Override
    public Task convert(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.isPresent() ?
                optionalTask.get() : null;
    }


}










