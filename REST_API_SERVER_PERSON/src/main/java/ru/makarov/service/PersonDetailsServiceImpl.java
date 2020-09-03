package ru.makarov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.makarov.model.Person;
import ru.makarov.repository.PersonRepository;

import static java.util.Collections.emptyList;

@Service
public class PersonDetailsServiceImpl implements UserDetailsService {
    private final PersonRepository personStore;

    @Autowired
    public PersonDetailsServiceImpl(PersonRepository personStore) {
        this.personStore = personStore;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Person user = personStore.findByUsername(login);
        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        return  new User(user.getUsername(),user.getPassword(), emptyList());
    }
}
