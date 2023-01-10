package com.api.people.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.people.dtos.AddressDto;
import com.api.people.models.AddressModel;
import com.api.people.models.PeopleModel;
import com.api.people.services.AddressService;
import com.api.people.services.PeopleService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/address")
public class AddressController {

  final AddressService addressService;
  final PeopleService peopleService;

  public AddressController(AddressService addressService, PeopleService peopleService) {
    this.addressService = addressService;
    this.peopleService = peopleService;
  }

  @PostMapping
  public ResponseEntity<Object> saveAddress(@RequestBody @Valid AddressDto addressDto) {

    Long id = addressDto.getPeopleId();

    if (!this.peopleService.existsById(id)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
    }

    PeopleModel peopleModel = new PeopleModel();
    peopleModel.setId(id);

    AddressModel addressModel = new AddressModel();
    BeanUtils.copyProperties(addressDto, addressModel);
    addressModel.setPeople(peopleModel);

    if (addressModel.getIsMainAddress()) {
      addressService.changeMainAddress(peopleModel);
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(addressModel));

  }

  @GetMapping("/people/{id}")
  public ResponseEntity<Object> getAddressByPeople(@PathVariable Long id) {

    if (!this.peopleService.existsById(id)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
    }

    return ResponseEntity.status(HttpStatus.OK).body(addressService.findByPeople(id));

  }

}
