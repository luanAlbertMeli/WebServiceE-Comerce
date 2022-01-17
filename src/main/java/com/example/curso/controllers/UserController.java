package com.example.curso.controllers;

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
    public ResponseEntity<List<User>> findAll(){
        List<User> usersList = userService.findAll();
       return ResponseEntity.ok().body(usersList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("add")
    public ResponseEntity<User> save(@RequestBody User user){
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(user.getId())
               .toUri();
        userService.add(user);
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User user){
        user = userService.update(id, user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
