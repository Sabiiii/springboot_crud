package com.example.crud.controller;

import com.example.crud.dao.KontaktRepository;
import com.example.crud.model.Kontaktperson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class KontaktController {

    private final KontaktRepository kontaktRepository;

    @Autowired
    public KontaktController(KontaktRepository kontaktrepository) {
        this.kontaktRepository = kontaktrepository;
    }

    @GetMapping
    public String showNewContactPage(Model model) {
        Kontaktperson kontakt = new Kontaktperson();
        model.addAttribute("kontakt", kontakt);
        return "new_contact";
    }

    @PostMapping
    public String saveContact(@ModelAttribute("kontakt") Kontaktperson kontaktperson) {
        kontaktRepository.save(kontaktperson);
        return "redirect:/";
    }
}










