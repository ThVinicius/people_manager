package com.api.people.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.people.models.AddressModel;
import com.api.people.models.PeopleModel;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {

  List<AddressModel> findByPeople(PeopleModel people);

  boolean findByIsMainAddress(boolean value);

}
