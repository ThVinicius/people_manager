package com.api.people;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.people.factories.AddressFactory;
import com.api.people.models.AddressModel;
import com.api.people.models.PeopleModel;
import com.api.people.repositories.AddressRepository;
import com.api.people.services.AddressService;

@DisplayName("AddressServiceTests")
public class AddressServiceTest extends ApplicationConfigTest {

  @MockBean
  private AddressRepository addressRepository;

  @Autowired
  private AddressService addressService;

  @Test
  @DisplayName("deve salvar um endereço")
  public void saveTest() {
    var peopleModel = new PeopleModel();
    peopleModel.setId(1L);

    var addressModel = new AddressFactory(1L, peopleModel, "16920000", "Castilho", "Rua Antonio Tavares", "123", true)
        .convert();

    Mockito.when(addressRepository.save(ArgumentMatchers.eq(addressModel))).thenReturn(addressModel);

    addressService.save(addressModel);

    Mockito.verify(addressRepository, Mockito.times(1)).save(ArgumentMatchers.any(AddressModel.class));

  }

  @Test
  @DisplayName("deve buscar todos os endereços criados pela pessoa com id 1")
  public void findByPeopleTest() {

    var peopleModel = new PeopleModel();
    peopleModel.setId(1L);

    var addressModel = new AddressFactory(1L, peopleModel, "16920000", "Castilho", "Rua Antonio Tavares", "123", true)
        .convert();

    List<AddressModel> addressList = new ArrayList<AddressModel>();
    addressList.add(addressModel);

    Mockito.when(addressRepository.findByPeople(ArgumentMatchers.eq(peopleModel))).thenReturn(addressList);

    addressService.findByPeople(1L);

    Mockito.verify(addressRepository, Mockito.times(1)).findByPeople(ArgumentMatchers.any(PeopleModel.class));

  }

}
