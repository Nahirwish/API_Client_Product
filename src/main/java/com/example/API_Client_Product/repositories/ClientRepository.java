package com.example.API_Client_Product.repositories;

import com.example.API_Client_Product.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
