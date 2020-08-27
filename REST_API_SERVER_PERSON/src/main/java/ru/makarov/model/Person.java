package ru.makarov.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Model op Person .
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;


    public Person() {
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Person)) return false;
        Person person = (Person) object;
        return getId() == person.getId() &&
                getLogin().equals(person.getLogin()) &&
                getPassword().equals(person.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword());
    }
}