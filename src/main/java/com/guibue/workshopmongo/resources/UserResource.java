package com.guibue.workshopmongo.resources;

import com.guibue.workshopmongo.domain.User;
import com.guibue.workshopmongo.dto.UserDTO;
import com.guibue.workshopmongo.services.UserService;
import com.guibue.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> dtoList = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserDTO dto = new UserDTO(service.findById(id));
        return ResponseEntity.ok().body(dto);
    }
}
