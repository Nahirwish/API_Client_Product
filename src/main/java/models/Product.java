package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Product {
    @Id
    private Integer idProduct;
    @NonNull
    private String productName;
    @NonNull
    private String productDescription;
    @NonNull
    private double productPrice;

    @ManyToOne
    private Client client;
}
