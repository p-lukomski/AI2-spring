package com.example.LAB13.service;

import com.example.LAB13.model.Person;
import com.example.LAB13.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPeople() { return repository.findAll(); }

    public Person getPerson(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Person with id " + id + "not found.")); }

    public Person createPerson(Person person) {
        validate(person);
        return repository.save(person);
    }

    public Person updatePerson(Long id, Person person) {
        Person existing = getPerson(id);
        validate(person);
        existing.setFirstName(person.getFirstName());
        existing.setFamilyName(person.getFamilyName());
        existing.setEmail(person.getEmail());
        existing.setAge(person.getAge());
        return repository.save(existing);
    }

    public void deletePerson(Long id) {
        Person existing = getPerson(id);
        repository.delete(existing);
    }

    private void validate(Person person) {
        if (person.getFirstName() == null || person.getFirstName().isBlank()) throw new IllegalArgumentException("First name is required.");
        if (person.getFamilyName() == null || person.getFamilyName().isBlank()) throw new IllegalArgumentException("Family name is required.");
        if (person.getEmail() == null || person.getEmail().isBlank()) throw new IllegalArgumentException("E-mail address is required.");
        if (person.getAge() == null && (person.getAge() < 0 || person.getAge() > 120)) throw new IllegalArgumentException("Invalid age.");
    }
}
