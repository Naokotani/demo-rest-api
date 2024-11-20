package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        personRepository.save(person);
        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        List<Person> people = personRepository.findAll();
        return ResponseEntity.ok(people);
    }
}
