package com.api.people.factories;

import com.api.people.models.AddressModel;
import com.api.people.models.PeopleModel;

public class AddressFactory {

  private Long id;
  private PeopleModel people;
  private String cep;
  private String city;
  private String publicArea;
  private String number;
  private boolean isMainAddress;

  public AddressFactory(Long id, PeopleModel people, String cep, String city, String publicArea, String number,
      boolean isMainAddress) {
    this.id = id;
    this.people = people;
    this.cep = cep;
    this.city = city;
    this.publicArea = publicArea;
    this.number = number;
    this.isMainAddress = isMainAddress;
  }

  public AddressModel convert() {

    var addressModel = new AddressModel();
    addressModel.setId(this.id);
    addressModel.setPeople(this.people);
    addressModel.setCep(this.cep);
    addressModel.setCity(this.city);
    addressModel.setPublicArea(this.publicArea);
    addressModel.setNumber(this.number);
    addressModel.setIsMainAddress(this.isMainAddress);

    return addressModel;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PeopleModel getPeople() {
    return people;
  }

  public void setPeople(PeopleModel people) {
    this.people = people;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPublicArea() {
    return publicArea;
  }

  public void setPublicArea(String publicArea) {
    this.publicArea = publicArea;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public boolean isMainAddress() {
    return isMainAddress;
  }

  public void setMainAddress(boolean isMainAddress) {
    this.isMainAddress = isMainAddress;
  }

}
