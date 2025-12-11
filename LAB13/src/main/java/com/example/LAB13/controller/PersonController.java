package com.example.LAB13.controller;

import com.example.LAB13.model.Person;
import com.example.LAB13.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) { this.service = service; }

    @GetMapping
    public List<Person> getPeople() { return service.getPeople(); }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getPerson(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createPerson(person));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal server error.");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        try {
            return ResponseEntity.ok(service.updatePerson(id, person));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        try {
            service.deletePerson(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal server error.");
        }
    }
}
