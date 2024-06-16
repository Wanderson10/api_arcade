package com.api_arcade.api_arcade.Repository.Addresses;
import com.api_arcade.api_arcade.Entities.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<Address,String>{
    
}
