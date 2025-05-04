package com.example.API_Client_Product.controllers;

import lombok.NonNull;
import com.example.API_Client_Product.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.API_Client_Product.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService cs;

    @PostMapping
    public ResponseEntity addClient(@RequestBody final @NonNull Client c){
        return cs.addClient(c);
    }

    @GetMapping("/getAll")
    public List<Client> getAll(){
        return cs.getAll();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable final @NonNull Integer id){
        return cs.getClient(id);
    }

    @GetMapping("/getTotal")
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
