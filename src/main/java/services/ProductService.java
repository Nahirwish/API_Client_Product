package services;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import repositories.ClientRepository;
import repositories.ProductRepository;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class ProductService {
    private final ProductRepository pr;
    private final ClientRepository cr;

    @Autowired
    public ProductService(ProductRepository pr, ClientRepository cr){
        this.pr = pr;
        this.cr = cr;
    }

    public ResponseEntity addProduct(Product p){
        try{
            pr.save(p);
            return ResponseEntity.status(CREATED).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

}
