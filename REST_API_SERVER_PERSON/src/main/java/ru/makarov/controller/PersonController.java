package ru.makarov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public PersonController(PersonRepository persons, BCryptPasswordEncoder encoder) {
        this.persons = persons;
        this.encoder = encoder;
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
     * Rest Api - for regestration new user.
     *
     * @param person - to register in DataBase.
     */
    @PostMapping("/sign-up")
    public void signUp(@RequestBody Person person) {
        person.setPassword(encoder.encode(person.getPassword()));
        person.setUsername(person.getUsername());
        persons.save(person);
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

}