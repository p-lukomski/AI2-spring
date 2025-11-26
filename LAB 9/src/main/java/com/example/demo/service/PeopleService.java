package com.example.demo.service;


import com.example.demo.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class PeopleService {
    private List<Person> people;

    @PostConstruct
    public void init() {
        people = new ArrayList<>();
        people.add(new Person("Łukasz", "Stanisławowski"));
        people.add(new Person("Jacek", "Iksiński"));
    }

    public List<Person> getPeople() { return people; }
    public Person getPerson(int index) { return people.get(index); }
    public void addPerson(Person person) { people.add(person); }
    public void setPerson(int index, Person person) { people.set(index, person); }
    public void removePerson(int index) { people.remove(index); }

}
