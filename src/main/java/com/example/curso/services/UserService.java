package com.example.curso.services;


import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
       Optional<User> user = userRepository.findById(id);
       return user.get();
    }

    public User add(User user){
        return userRepository.save(user);
    }

    public User update(Long id, User user){
        User entity = userRepository.getById(id);
       updateData(entity, user);
       return userRepository.save(entity);

    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
