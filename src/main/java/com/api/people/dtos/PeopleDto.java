package com.api.people.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PeopleDto {

  @Size(max = 10)
  @NotBlank
  private String name;

  @NotBlank
  @Size(min = 10, max = 10)
  @Pattern(regexp = "^$|^([0-9]{2}/[0-9]{2}/[0-9]{4})$", message = "Date format should be dd/mm/yyyy")
  private String birthDate;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

}
