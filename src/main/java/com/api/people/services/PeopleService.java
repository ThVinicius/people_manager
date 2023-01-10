package com.api.people.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.people.models.PeopleModel;
import com.api.people.repositories.PeopleRepository;

import jakarta.transaction.Transactional;

@Service
public class PeopleService {
  final PeopleRepository peopleRepository;

  public PeopleService(PeopleRepository peopleRepository) {
    this.peopleRepository = peopleRepository;
  }

  public Optional<PeopleModel> findById(Long id) {
    return this.peopleRepository.findById(id);
  }

  public List<PeopleModel> findAll() {
    return peopleRepository.findAll();
  }

  @Transactional
  public PeopleModel save(PeopleModel peopleModel) {
    return peopleRepository.save(peopleModel);
  }

  public boolean existsById(Long id) {
    return peopleRepository.existsById(id);
  }

}
