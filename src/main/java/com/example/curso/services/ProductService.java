package com.example.curso.services;


import com.example.curso.entities.Product;
import com.example.curso.entities.User;
import com.example.curso.repositories.ProductRepository;
import com.example.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
       Optional<Product> product = productRepository.findById(id);
       return product.get();
    }

    public Product add(Product prod){
        return productRepository.save(prod);
    }

    public Product update(Long id, Product prod){
        Product entity = productRepository.getById(id);
       updateData(entity, prod);
       return productRepository.save(entity);

    }

    private void updateData(Product entity, Product prod) {
        entity.setName(prod.getName());
        entity.setDescription(prod.getDescription());
        entity.setPrice(prod.getPrice());
        entity.setImgUrl(prod.getImgUrl());
    }

    public void deleteProd(Long id){
        productRepository.deleteById(id);
    }
}
