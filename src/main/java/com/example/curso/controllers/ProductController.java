package com.example.curso.controllers;

import com.example.curso.entities.Product;
import com.example.curso.entities.User;
import com.example.curso.services.ProductService;
import com.example.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> prodList = productService.findAll();
       return ResponseEntity.ok().body(prodList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product prod = productService.findById(id);
        return ResponseEntity.ok().body(prod);
    }

    @PostMapping("add")
    public ResponseEntity<Product> save(@RequestBody Product prod){
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(prod.getId())
               .toUri();
        productService.add(prod);
        return ResponseEntity.created(uri).body(prod);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,@RequestBody Product prod){
        prod = productService.update(id, prod);
        return ResponseEntity.ok().body(prod);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        productService.deleteProd(id);
        return ResponseEntity.noContent().build();
    }
}
