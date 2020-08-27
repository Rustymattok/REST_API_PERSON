package ru.makarov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.makarov.model.Message;
import ru.makarov.model.Person;
import ru.makarov.model.Room;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Integer> {
    List<Message> findMessagesByPerson(Person person);
    List<Message> findMessagesByRoom(Room room);
}
