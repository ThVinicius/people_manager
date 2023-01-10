package com.api.people.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class AddressModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "peopleId", referencedColumnName = "id", nullable = false)
  private PeopleModel people;

  @Column(nullable = false)
  private String publicArea;

  @Column(nullable = false)
  private String cep;

  @Column(nullable = false)
  private String number;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private boolean isMainAddress;

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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public boolean getIsMainAddress() {
    return isMainAddress;
  }

  public void setIsMainAddress(boolean isMainAddress) {
    this.isMainAddress = isMainAddress;
  }

}
