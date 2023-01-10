package com.api.people;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.people.factories.PeopleFactory;
import com.api.people.models.PeopleModel;
import com.api.people.repositories.PeopleRepository;
import com.api.people.services.PeopleService;

@DisplayName("PeopleTests")
public class PeopleServiceTest extends ApplicationConfigTest {

  @MockBean
  private PeopleRepository peopleRepository;

  @Autowired
  private PeopleService peopleService;

  @Test
  @DisplayName("deve salvar um endereço")
  public void saveTest() {
    var peopleModel = new PeopleFactory(1L, "José", "01/01/2000").convert();

    Mockito.when(peopleRepository.save(ArgumentMatchers.eq(peopleModel))).thenReturn(peopleModel);

    peopleService.save(peopleModel);

    Mockito.verify(peopleRepository, Mockito.times(1)).save(ArgumentMatchers.any(PeopleModel.class));

  }

  @Test
  @DisplayName("deve retornar todas as pessoas")
  public void findAllTest() {
    var peopleModel = new PeopleFactory(1L, "José", "01/01/2000").convert();

    List<PeopleModel> peopleList = new ArrayList<PeopleModel>();
    peopleList.add(peopleModel);

    Mockito.when(peopleRepository.findAll()).thenReturn(peopleList);

    List<PeopleModel> response = peopleService.findAll();

    Mockito.verify(peopleRepository, Mockito.times(1)).findAll();

    assertNotNull(response);
    assertEquals(1, response.size());
    assertEquals(PeopleModel.class, response.get(0).getClass());
  }

  @Test
  @DisplayName("deve retornar uma pessoa por id")
  public void findByIdTest() {
    Long id = 1L;
    PeopleModel peopleModel = new PeopleFactory(id, "Maria", "25/12/2001").convert();
    Optional<PeopleModel> peopleOptional = Optional.of(peopleModel);

    Mockito.when(peopleRepository.findById(ArgumentMatchers.eq(id))).thenReturn(peopleOptional);

    Optional<PeopleModel> response = peopleService.findById(id);

    assertNotNull(response);
    assertNotNull(response.get());
    assertEquals(1L, response.get().getId());
  }

  @Test
  @DisplayName("deve retornar true caso ache a pessoa")
  public void existsByIdTest() {
    Long id = 1L;

    Mockito.when(peopleRepository.existsById(ArgumentMatchers.eq(id))).thenReturn(true);

    boolean response = peopleService.existsById(id);

    assertNotNull(response);
    assertEquals(true, response);
  }

}
