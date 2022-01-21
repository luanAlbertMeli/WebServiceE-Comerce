package com.example.curso.controllers;

import com.example.curso.entities.Category;
import com.example.curso.entities.User;
import com.example.curso.repositories.CategoryRepository;
import com.example.curso.services.CategoryService;
import com.example.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categoryList = categoryService.findAll();
       return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> save(@RequestBody Category cat){
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(cat.getId())
               .toUri();
        categoryService.add(cat);
        return ResponseEntity.created(uri).body(cat);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
