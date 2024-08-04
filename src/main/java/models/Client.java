package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Client {
    @Id
    private Integer idClient;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Integer phoneNumber;
    private String address;
    private String eMail;

    @OneToMany(mappedBy = "Client")
    private ArrayList<Product> products;
}
