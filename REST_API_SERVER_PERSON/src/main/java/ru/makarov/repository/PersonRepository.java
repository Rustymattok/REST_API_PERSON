package ru.makarov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.makarov.model.Person;

import java.util.List;

/**
 * DATA for person.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findAllById(int id);
}