package ru.makarov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.makarov.model.Room;

public interface RoomRepository  extends CrudRepository<Room,Integer> {
    Room findRoomById(int id);
}
