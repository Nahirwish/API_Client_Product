package services;

import models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import repositories.ClientRepository;
import repositories.ProductRepository;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class ClientService {
    private final ClientRepository cr;
    private final ProductRepository pr;

    @Autowired
    public ClientService(ClientRepository cr, ProductRepository pr){
        this.cr = cr;
        this.pr = pr;
    }

    public ResponseEntity addClient(Client c){
        try {
            cr.save(c);
            return ResponseEntity.status(CREATED).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public List<Client> getAll(){
        return cr.findAll();
    }

    public Client getClient(Integer id){
        return cr.findById(id).orElseThrow(()-> new HttpClientErrorException(BAD_REQUEST, "Client not found"));
    }

    public Integer getTotal(){
        return cr.findAll().size();
    }

    public ResponseEntity updateClient(Client c, Integer id){
        try{
            Client cl = cr.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Client not found"));
            cl.setIdClient(c.getIdClient());
            cl.setFirstName(c.getFirstName());
            cl.setLastName(c.getLastName());
            cl.setPhoneNumber(c.getPhoneNumber());
            cl.setAddress(c.getAddress());
            cr.save(cl);
            return ResponseEntity.status(OK).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity deleteClient(Integer id){
        try {
            cr.deleteById(id);
            return ResponseEntity.status(OK).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

}
