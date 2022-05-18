package com.kneerecoveryhelper.controller.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PatientRequest {
  private String firstName;
  private String secondName;
  private String patronymic;
  @NotBlank
  @Email
  private String email;
  private String phoneNumber;
  private String medicalCardNumber;
}
