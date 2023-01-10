package com.api.people.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.people.models.AddressModel;
import com.api.people.models.PeopleModel;
import com.api.people.repositories.AddressRepository;

import jakarta.transaction.Transactional;

@Service
public class AddressService {

  final AddressRepository addressRepository;

  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  @Transactional
  public AddressModel save(AddressModel addressModel) {
    return addressRepository.save(addressModel);
  }

  public List<AddressModel> findByPeople(Long id) {
    var peopleModel = new PeopleModel();
    peopleModel.setId(id);

    return addressRepository.findByPeople(peopleModel);
  }

  public void changeMainAddress(PeopleModel people) {

    List<AddressModel> addressList = this.findByPeople(people.getId());

    for (int i = 0; i < addressList.size(); i++) {
      AddressModel address = addressList.get(i);

      if (address.getIsMainAddress()) {
        address.setIsMainAddress(false);

        break;
      }
    }
  }
}
