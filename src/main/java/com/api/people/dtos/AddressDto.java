package com.api.people.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddressDto {

  @NotNull
  private Long peopleId;

  @NotBlank
  private String publicArea;

  @NotBlank
  @Size(max = 8)
  private String cep;

  @NotBlank
  private String city;

  @NotBlank
  private String number;

  @NotNull
  private boolean isMainAddress;

  public Long getPeopleId() {
    return peopleId;
  }

  public void setPeopleId(Long peopleId) {
    this.peopleId = peopleId;
  }

  public String getPublicArea() {
    return publicArea;
  }

  public void setPublicArea(String publicArea) {
    this.publicArea = publicArea;
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
