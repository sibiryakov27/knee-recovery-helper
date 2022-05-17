package com.kneerecoveryhelper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class PatientEntity extends UserEntity {

  @Column(name = "medical_card_number")
  private String medicalCardNumber;

}
