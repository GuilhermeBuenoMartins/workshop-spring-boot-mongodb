package com.guibue.workshopmongo.services;

import com.guibue.workshopmongo.domain.User;
import com.guibue.workshopmongo.dto.UserDTO;
import com.guibue.workshopmongo.repository.UserRepository;
import com.guibue.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> optional =  repository.findById(id);
        if (optional.isEmpty()) throw new ObjectNotFoundException("Objeto não encontrado");
        return optional.get();
    }
    public User insert(User user) {
        return repository.insert(user);
    }

    public User fromDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
