package com.adress.Address.controller;

import com.adress.Address.model.dto.AddressDTO;
import com.adress.Address.model.dto.AddressRequest;
import com.adress.Address.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PutMapping("/update/{empId}")
  public ResponseEntity<List<AddressDTO>> updateAddress(
      @RequestBody AddressRequest addressDTO, @PathVariable Long empId) {
    List<AddressDTO> response = addressService.updateAddress(addressDTO);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/all-address")
  public ResponseEntity<List<AddressDTO>> getAllAddress() {
    List<AddressDTO> response = addressService.getAllAddress();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{addressId}")
  public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
    AddressDTO response = addressService.getSingleAddress(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
