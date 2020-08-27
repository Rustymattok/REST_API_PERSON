package ru.makarov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.makarov.model.Person;
import ru.makarov.model.Room;

import java.util.List;

public interface RoomRepository  extends CrudRepository<Room,Integer> {
    Room findRoomById(int id);
}
