package com.example.API_Client_Product.repositories;

import com.example.API_Client_Product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
