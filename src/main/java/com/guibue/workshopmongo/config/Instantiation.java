package com.guibue.workshopmongo.config;

import com.guibue.workshopmongo.domain.Post;
import com.guibue.workshopmongo.domain.User;
import com.guibue.workshopmongo.dto.AuthorDTO;
import com.guibue.workshopmongo.repository.PostRepository;
import com.guibue.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        Post post1 = new Post(null, dateFormat.parse("2018-03-21"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
                new AuthorDTO(maria));
        Post post2 = new Post(null, dateFormat.parse("2018-03-23"), "Bom dia", "Acordei feliz hoje!",
                new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1, post2));
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
