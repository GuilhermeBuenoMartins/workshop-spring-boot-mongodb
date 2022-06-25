package com.guibue.workshopmongo.services;

import com.guibue.workshopmongo.domain.Post;
import com.guibue.workshopmongo.repository.PostRepository;
import com.guibue.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> optional = repository.findById(id);
        if (optional.isEmpty()) throw new ObjectNotFoundException("Objeto não encontrado");
        return optional.get();
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
