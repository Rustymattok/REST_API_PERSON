package ru.makarov.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Message)) return false;
        Message message = (Message) object;
        return getId() == message.getId() &&
                getContent().equals(message.getContent()) &&
                getPerson().equals(message.getPerson()) &&
                getRoom().equals(message.getRoom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContent(), getPerson(), getRoom());
    }
}
