package com.example.crud.controller;

import com.example.crud.model.Kontaktperson;
import com.example.crud.model.Task;
import com.example.crud.dao.TaskRepository;
import com.example.crud.dao.MitarbeiterRepository;
import com.example.crud.dao.TaetigkeitsRepository;
import com.example.crud.model.Mitarbeiter;
import com.example.crud.model.Taetigkeit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MitarbeiterController {

    private final MitarbeiterRepository mitarbeiterRepository;

    private final TaetigkeitsRepository taetigkeitsRepository;

    private final TaskRepository taskRepository;
    //Starts the Dependency Injection! -> adds the Repository to the constructor
    @Autowired
    public MitarbeiterController(MitarbeiterRepository mitarbeiterRepository, TaskRepository taskRepository,TaetigkeitsRepository taetigkeitsRepository) {
        this.mitarbeiterRepository = mitarbeiterRepository;
        this.taskRepository = taskRepository;
        this.taetigkeitsRepository = taetigkeitsRepository;
    }

    @RequestMapping("/employee")
    public String showNewEmployeePage(Model model) {
        Mitarbeiter mitarbeiter= new Mitarbeiter();
        model.addAttribute("mitarbeiter", mitarbeiter);
        return "new_employee";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("mitarbeiter") Mitarbeiter mitarbeiter) {
        // ist getting the DI to work!
        mitarbeiterRepository.save(mitarbeiter);
        return "redirect:/";
    }
    //refers to the object in the form
    @RequestMapping("/allEmployee")
    public String showAllEmployeePage(Model model) {
        List<Mitarbeiter> mitarbeiterlist = new ArrayList<>();
        mitarbeiterRepository.findAll().forEach(i -> mitarbeiterlist.add(i));
        model.addAttribute("mitarbeiterlist", mitarbeiterlist);
        return "/all_employee";
    }

    @RequestMapping("/editEmployee/{id}")
    public String showEditProductPage(@PathVariable(name = "id") Long id, Model model, @ModelAttribute Kontaktperson kontaktperson) {
        Mitarbeiter mitarbeiter = mitarbeiterRepository.findById(id).get();
        model.addAttribute("mitarbeiter", mitarbeiter);
        return "edit_employee";
    }

    @RequestMapping(value = "/updateEmpl", method = RequestMethod.POST)
    public String saveUpdatedEmployee(Mitarbeiter mitarbeiter, BindingResult result, Model model) {
        mitarbeiterRepository.save(mitarbeiter);
        return "redirect:/";

    }
    @RequestMapping("/deleteEmployee/{id}")
    public String deleteEmployeeById(@PathVariable(name = "id") Long id, Model model) {
        mitarbeiterRepository.deleteById(id);
        return "redirect:/";
    }

    }









