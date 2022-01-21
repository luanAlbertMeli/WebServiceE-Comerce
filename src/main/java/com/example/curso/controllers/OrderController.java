 package com.example.curso.controllers;

import com.example.curso.entities.Order;
import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;
import com.example.curso.services.OrderService;
import com.example.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orderList = orderService.findAll();
       return ResponseEntity.ok().body(orderList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
    @PostMapping("add")
    public ResponseEntity<Order> save(@RequestBody Order order){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();
        orderService.add(order);
        return ResponseEntity.created(uri).body(order);
    }

}
