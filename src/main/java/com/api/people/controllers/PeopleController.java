package com.api.people.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.people.dtos.PeopleDto;
import com.api.people.models.PeopleModel;
import com.api.people.services.PeopleService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/people")
public class PeopleController {

  final PeopleService peopleService;

  public PeopleController(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @PostMapping
  public ResponseEntity<Object> savePeople(@RequestBody PeopleModel peopleModel) {

    return ResponseEntity.status(HttpStatus.CREATED).body(peopleService.save(peopleModel));

  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Object> updatePeople(@PathVariable Long id, @RequestBody @Valid PeopleDto peopleDto) {
    Optional<PeopleModel> peopleModelOptional = peopleService.findById(id);

    if (!peopleModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
    }

    var peopleModel = new PeopleModel();
    BeanUtils.copyProperties(peopleDto, peopleModelOptional);
    peopleModel.setId(peopleModelOptional.get().getId());
    peopleModel.setName(peopleModelOptional.get().getName());
    peopleModel.setBirthDate(peopleModelOptional.get().getBirthDate());

    return ResponseEntity.status(HttpStatus.OK).body(peopleService.save(peopleModel));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getPerson(@PathVariable Long id) {
    Optional<PeopleModel> peopleModelOptional = peopleService.findById(id);

    if (!peopleModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
    }

    return ResponseEntity.status(HttpStatus.OK).body(peopleModelOptional.get());

  }

  @GetMapping
  public ResponseEntity<List<PeopleModel>> getAllPeople() {
    return ResponseEntity.status(HttpStatus.OK).body(peopleService.findAll());
  }

}
