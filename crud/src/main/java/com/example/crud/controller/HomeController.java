package com.example.crud.controller;

import com.example.crud.dao.TaetigkeitsRepository;
import com.example.crud.dao.TaskRepository;
import com.example.crud.model.Taetigkeit;
import com.example.crud.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final TaskRepository taskRepository;

    private final TaetigkeitsRepository taetigkeitsRepository;


    @Autowired
    public HomeController(TaskRepository taskRepository, TaetigkeitsRepository taetigkeitsRepository) {
        this.taskRepository = taskRepository;
        this.taetigkeitsRepository = taetigkeitsRepository;
    }



    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Task> listTasks = new ArrayList<>();
        List<Taetigkeit> listTaetigkeiten = new ArrayList<>();
        taskRepository.findAll().forEach(i -> listTasks.add(i));
        taetigkeitsRepository.findAll().forEach(i -> listTaetigkeiten.add(i));
        model.addAttribute("listTasks", listTasks);
        model.addAttribute("listTaetigkeiten", listTaetigkeiten);
        return "index";
    }



}
