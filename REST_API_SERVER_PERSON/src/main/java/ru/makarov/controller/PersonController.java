package ru.makarov.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.makarov.model.Person;
import ru.makarov.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Main conrtoller for REST API.
 */
@RestController
public class PersonController {
    private final PersonRepository persons;

    public PersonController(final PersonRepository persons) {
        this.persons = persons;
    }

    /**
     * Sample GET req: curl -i http://localhost:8080/person/.
     *
     * @return - all data in JSON format.
     */
    @GetMapping("/person")
    public List<Person> findAll() {
        return StreamSupport.stream(
                this.persons.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    /**
     * Sample GET req: curl -i http://localhost:8080/person/1.
     *
     * @param id - person by ID for return.
     * @return - person data by id in JSON format.
     */
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> findById(@PathVariable int id) {
        Person person = persons.findAllById(id);
        boolean flag = persons.findById(id).isPresent();
        return new ResponseEntity<Person>(person, flag ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    /**
     * Sample POST req: curl -H 'Content-Type: application/json' -X POST -d '{"login":"job4j@gmail.com","password":"123"}' http://localhost:8080/person/.
     *
     * @param person - in JSON {:} format.
     * @return - post result. add parameter to DATA.
     */
    @PostMapping("/person")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<Person>(
                this.persons.save(person),
                HttpStatus.CREATED
        );
    }
}