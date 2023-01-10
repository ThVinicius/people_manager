package com.api.people.factories;

import com.api.people.models.PeopleModel;

public class PeopleFactory {

  private Long id;
  private String name;
  private String birthDate;

  public PeopleFactory(Long id, String name, String birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  public PeopleModel convert() {
    var peopleModel = new PeopleModel();
    peopleModel.setId(this.id);
    peopleModel.setName(this.name);
    peopleModel.setBirthDate(this.birthDate);

    return peopleModel;
  }

}
