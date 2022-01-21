package com.example.curso.services;


import com.example.curso.entities.Category;
import com.example.curso.entities.User;
import com.example.curso.repositories.CategoryRepository;
import com.example.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
       Optional<Category> category = categoryRepository.findById(id);
       return category.get();
    }

    public Category add(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
