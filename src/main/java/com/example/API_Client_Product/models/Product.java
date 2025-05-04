package com.example.API_Client_Product.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduct;

    @NonNull
    @Column(name = "productName")
    private String productName;

    @NonNull
    @Column(name = "productDescription")
    private String productDescription;

    @NonNull
    @Column(name = "productImage")
    private String productImage;

    @NonNull
    @Column(name = "productPrice")
    private double productPrice;

    @NonNull
    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    private Client client;
}
        