package com.api.people.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.people.models.PeopleModel;

public interface PeopleRepository extends JpaRepository<PeopleModel, Long> {

  boolean existsById(Long id);

}
