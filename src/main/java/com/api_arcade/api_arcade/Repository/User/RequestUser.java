package com.api_arcade.api_arcade.Repository.User;

import java.util.List;

import com.api_arcade.api_arcade.Entities.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RequestUser(

    @NotNull
    String name, 

    @Email
    @NotNull
    String email,
    
     List<Address> addresses
    
    ){

    }
    
    
    

    

