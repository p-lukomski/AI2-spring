package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    final PeopleService peopleService;

    @Autowired
    public HelloController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public String people(Model model) {
        model.addAttribute("people", peopleService.getPeople());
        return "people";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "edit";
    }

    @PostMapping("/save")
    public String save(Person person) {
        peopleService.addPerson(person);
        return "redirect:/people";
    }
}
