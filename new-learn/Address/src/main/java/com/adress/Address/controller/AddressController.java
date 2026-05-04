package com.adress.Address.controller;

import com.adress.Address.model.dto.AddressDTO;
import com.adress.Address.model.dto.AddressRequest;
import com.adress.Address.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

  private final AddressService addressService;

  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  @PostMapping("/save")
  public ResponseEntity<List<AddressDTO>> saveAddresses(@RequestBody AddressRequest addressRequest){
    List<AddressDTO> savedListAddress = addressService.saveAddress(addressRequest);
    return new ResponseEntity<>(savedListAddress, HttpStatus.CREATED);
  }

}
