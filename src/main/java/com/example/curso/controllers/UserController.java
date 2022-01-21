package com.example.curso.controllers;

import com.example.curso.DTO.UserDTO;
import com.example.curso.entities.User;
import com.example.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> usersList = userService.findAll();
       return ResponseEntity.ok().body(UserDTO.convert(usersList));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(UserDTO.convert(userService.findById(id)));
    }

    @PostMapping("add")
    public ResponseEntity<UserDTO> save(@RequestBody User user){
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(user.getId())
               .toUri();
        userService.add(user);
        return ResponseEntity.created(uri).body(UserDTO.convert(user));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id,@RequestBody User user){
        user = userService.update(id, user);
        return ResponseEntity.ok().body(UserDTO.convert(user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
