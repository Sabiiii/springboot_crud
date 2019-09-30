package com.example.crud.controller;

import com.example.crud.dao.MitarbeiterRepository;
import com.example.crud.dao.TaetigkeitsRepository;
import com.example.crud.dao.TaskRepository;
import com.example.crud.model.Mitarbeiter;
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
public class TaetigkeitsController {

    private final MitarbeiterRepository mitarbeiterRepository;

    private final TaetigkeitsRepository taetigkeitsRepository;

    private final TaskRepository taskRepository;

    @Autowired
    public TaetigkeitsController(MitarbeiterRepository mitarbeiterRepository, TaetigkeitsRepository taetigkeitsRepository, TaskRepository taskRepository) {
        this.mitarbeiterRepository = mitarbeiterRepository;
        this.taetigkeitsRepository = taetigkeitsRepository;
        this.taskRepository = taskRepository;
    }

    //linking the index link to the request the name id of thymeleaf there
    @RequestMapping(value = "/addTaetigkeit/{id}", method = RequestMethod.GET)
    public String showAddTaetigkeit(@PathVariable(name = "id") Long id, Model model, @ModelAttribute Mitarbeiter mitarbeiter) {
        Task task = taskRepository.findById(id).get();
        Taetigkeit taetigkeit = new Taetigkeit();
        List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
        mitarbeiterRepository.findAll().forEach(i -> mitarbeiterList.add(i));
        model.addAttribute("mitarbeiterList", mitarbeiterList);
        model.addAttribute("task", task);
        model.addAttribute("taetigkeit", taetigkeit);
        return "add_taetigkeit";
    }


    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.POST)
    public String TaskAddEmployee(@PathVariable(name = "id") Long id, @ModelAttribute("taetigkeit") Taetigkeit taetigkeit, BindingResult result, @ModelAttribute Mitarbeiter mitarbeiter) {
        Task task = taskRepository.findById(id).get();
        taetigkeit.setTask(task);
        taetigkeit.setMitarbeiter(mitarbeiter);
        taetigkeitsRepository.save(taetigkeit);

        //@modelattribute saves the binding of the object task

        return "redirect:/";
    }

}
