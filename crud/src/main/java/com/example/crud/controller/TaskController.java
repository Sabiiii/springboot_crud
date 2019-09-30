package com.example.crud.controller;

import com.example.crud.model.Kontaktperson;
import com.example.crud.dao.KontaktRepository;
import com.example.crud.dao.TaskRepository;
import com.example.crud.model.Taetigkeit;
import com.example.crud.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    private final KontaktRepository kontaktRepository;


    @Autowired
    public TaskController(TaskRepository taskRepository, KontaktRepository kontaktRepository) {
        this.taskRepository = taskRepository;
        this.kontaktRepository = kontaktRepository;

    }

    @RequestMapping("/new")
    //Add Modelattribute automatically adds the Kontaktperson to the model
    public String showNewTaskPage(Model model, @ModelAttribute Kontaktperson kontaktperson) {
        Task task = new Task();
        List<Kontaktperson> kontaktpersonList = new ArrayList<>();
        kontaktRepository.findAll().forEach(i -> kontaktpersonList.add(i));
        model.addAttribute("task", task);
        model.addAttribute("kontaktpersonlist", kontaktpersonList);
        return "new_task";
    }


    //Only POST Request are saving data saves the new created Task
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") Task task, BindingResult result) {
        taskRepository.save(task);
        return "redirect:/";
    }


    @RequestMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") Long id, Model model, @ModelAttribute Kontaktperson kontaktperson) {
        Task task = taskRepository.findById(id).get();
        List<Kontaktperson> kontaktpersonList = new ArrayList<>();
        kontaktRepository.findAll().forEach(i -> kontaktpersonList.add(i));
        model.addAttribute("task", task);
        model.addAttribute("kontaktpersonlist", kontaktpersonList);
        return "edit_task";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveUpdatedTask(Task task, BindingResult result, Model model) {
        taskRepository.save(task);
        return "redirect:/";

    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable(name = "id") Long id, Model model) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }


}











