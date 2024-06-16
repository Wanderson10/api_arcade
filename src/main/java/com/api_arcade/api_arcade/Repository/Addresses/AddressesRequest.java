package com.api_arcade.api_arcade.Repository.Addresses;
import com.api_arcade.api_arcade.Entities.User;

public record AddressesRequest(
    String city,
    String street,
    int number,
    String state,
    int cep,
    User users  
) {
    
}
