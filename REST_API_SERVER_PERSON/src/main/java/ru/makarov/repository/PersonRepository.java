package ru.makarov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.makarov.model.Person;

/**
 * DATA for person.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findAllById(int id);
    Person findByUsername(String username);
}