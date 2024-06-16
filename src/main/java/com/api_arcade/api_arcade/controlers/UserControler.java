package com.api_arcade.api_arcade.controlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_arcade.api_arcade.Entities.Address;
import com.api_arcade.api_arcade.Entities.User;
import com.api_arcade.api_arcade.Repository.User.RequestUser;
import com.api_arcade.api_arcade.Repository.User.UserRepository;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/users")
public class UserControler {
    
    @Autowired
    private UserRepository repository;

 
    @GetMapping
    public ResponseEntity <List<User>> getAllUsers(){
        var allUsers = repository.findAll();
        return ResponseEntity.ok(allUsers);

    }

    @PostMapping
    public ResponseEntity<User> postUser (@RequestBody  @Valid RequestUser data){
        System.out.println(data);
        User newUser = new User (data);

    
        if(data.addresses() != null){
            List<Address>address = data.addresses();
            System.out.println(address);
            newUser.getAddresses().addAll(address);
        }
        try{
            repository.save(newUser);
            return ResponseEntity.ok(newUser);
        }catch (Exception e){
             System.err.println("Erro ao salvar o usuário: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
     
      
       

    }
}