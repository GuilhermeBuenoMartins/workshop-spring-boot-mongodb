package com.guibue.workshopmongo.config;

import com.guibue.workshopmongo.domain.User;
import com.guibue.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        userRepository.deleteAll();
        List<User> users = new ArrayList<>();
        users.add(new User(null, "Maria Brown", "maria@gmail.com"));
        users.add(new User(null, "Alex Green", "alex@gmail.com"));
        users.add(new User(null, "Bob Grey", "bob@gmail.com"));
        userRepository.saveAll(users);
    }
}
