package controllers;

import lombok.NonNull;
import models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ClientService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
@RestController("/client")
public class ClientController {
    @Autowired
    private ClientService cs;

    @PostMapping
    public ResponseEntity addClient(@RequestBody final @NonNull Client c){
        return cs.addClient(c);
    }

    @GetMapping
    public List<Client> getAll(){
        return cs.getAll();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable final @NonNull Integer id){
        return cs.getClient(id);
    }

    @GetMapping
    public  Integer getTotal(){
        return cs.getTotal();
    }

    @PostMapping("{id}/update")
    public ResponseEntity updateClient(@PathVariable final @NonNull Integer id, @RequestBody final @NonNull Client c){
        return cs.updateClient(c, id);
    }

    @PostMapping("{id}/delete")
    public ResponseEntity deleteClient(@PathVariable final @NonNull Integer id){
        return cs.deleteClient(id);

    }


}
