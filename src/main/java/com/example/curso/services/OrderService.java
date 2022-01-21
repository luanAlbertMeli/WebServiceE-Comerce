package com.example.curso.services;


import com.example.curso.entities.Order;
import com.example.curso.entities.User;
import com.example.curso.repositories.OrderRepository;
import com.example.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
       Optional<Order> order = orderRepository.findById(id);
       return order.get();
    }

    public Order add(Order order){
        return orderRepository.save(order);
    }
}
