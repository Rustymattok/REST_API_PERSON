package ru.makarov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.makarov.model.Message;
import ru.makarov.repository.MessageRepository;
import ru.makarov.repository.PersonRepository;
import ru.makarov.repository.RoomRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MesasageControl {
    private final RoomRepository roomRepository;
    private final PersonRepository personRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public MesasageControl(RoomRepository roomRepository, PersonRepository personRepository, MessageRepository messageRepository) {
        this.roomRepository = roomRepository;
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }

    /**
     * \
     * Rest Mapping to recieve all messages in room.
     * @param id - room.
     * @return list of messages due room.
     */
    //todo велосипед для того чтобы захайдить данные о Person.
    //todo в дальнешем если админ можно все видеть, если пользователь то в хайд.
    @GetMapping("/room/{id}/messages")
    public List<Message> findAll(@PathVariable int id) {
        List<Message> messages = this.messageRepository.findMessagesByRoom(roomRepository.findRoomById(id));
        return messages.stream().filter(message -> {
            message.getPerson().setPassword(null);
            return true;
        }).collect(Collectors.toList());
    }

    //todo сделать админ request все кто в чате.
    //todo приват чат надо делать или уже после ролей?.


}
