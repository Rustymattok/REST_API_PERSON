package ru.makarov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.makarov.model.Message;
import ru.makarov.repository.MessageRepository;
import ru.makarov.repository.RoomRepository;

import java.util.List;

@RestController
public class MesasageControl {
    private final RoomRepository rooms;
    private final MessageRepository messages;

    @Autowired
    public MesasageControl(RoomRepository roomRepository, MessageRepository messageRepository) {
        this.rooms = roomRepository;
        this.messages = messageRepository;
    }

    /**
     * \
     * Rest Mapping to recieve all messages in room.
     *
     * @param id - room.
     * @return list of messages due room.
     */
    @GetMapping("/room/{id}/messages")
    public List<Message> findAll(@PathVariable int id) {
        List<Message> messages = this.messages.findMessagesByRoom(rooms.findRoomById(id));
        return messages;
    }
}
