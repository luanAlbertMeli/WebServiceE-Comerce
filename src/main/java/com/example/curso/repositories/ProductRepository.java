package com.example.curso.repositories;

import com.example.curso.entities.Category;
import com.example.curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
