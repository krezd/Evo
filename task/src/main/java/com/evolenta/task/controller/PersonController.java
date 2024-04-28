package com.evolenta.task.controller;

import com.evolenta.task.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person(1, "Ivan", "Ivanovich", "Ivanov", LocalDate.of(1999, 2, 3)),
            new Person(2, "Петр", "Петрович", "Петров", LocalDate.of(2002, 2, 2)),
            new Person(3, "Евгений", "Васильевич", "Васин", LocalDate.of(2005, 4, 8)),
            new Person(4, "Максим", "Яковлевич", "Окопский", LocalDate.of(1978, 6, 5))
    ));

    @GetMapping
    public ResponseEntity<?> getAllPerson() {
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public Optional<?> findPersonById(@PathVariable int id) {
        return persons.stream().filter(p -> p.getId() == id).findFirst();
    }

    @PostMapping("")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        persons.add(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable int id, @RequestBody Person person) {
        int index = -1;
        for (Person p : persons) {
            if (p.getId() == id) {
                index = persons.indexOf(p);
                persons.set(index, person);
            }
        }
        if (index == -1) {
            addPerson(person);
        }
        return new ResponseEntity<>(person,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable int id) {
        persons.removeIf(p -> p.getId() == id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
