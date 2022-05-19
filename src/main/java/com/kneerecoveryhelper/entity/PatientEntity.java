package com.kneerecoveryhelper.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "patients")
@Getter
@Setter
@Accessors(chain = true)
public class PatientEntity extends UserEntity {

  @Column(name = "start_recovery_date", columnDefinition = "DATE")
  private Date startRecoveryDate;

  @Column(name = "medical_card_number")
  private String medicalCardNumber;

}
