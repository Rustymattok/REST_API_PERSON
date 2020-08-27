package ru.makarov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.makarov.model.Room;
import ru.makarov.repository.RoomRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Rest controller for room info.
 */
@RestController
public class RoomController {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    /**
     * Mapping for get all rooms in chat.
     * @return - list of rooms.
     */
    @GetMapping("/room")
    public List<Room> findAll() {
        return StreamSupport.stream(
                this.roomRepository.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    /**
     * Mapping for create room chat.
     * @param room - parameters for room in post,
     * @return room save to DataBase.
     */
    @PostMapping("/room")
    public ResponseEntity<Room> create(@RequestBody Room room) {
        return new ResponseEntity<Room>(
                this.roomRepository.save(room),
                HttpStatus.CREATED
        );
    }
}
