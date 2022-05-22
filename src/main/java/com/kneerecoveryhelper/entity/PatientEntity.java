package com.kneerecoveryhelper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

  @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
  private List<ExercisesEntity> exercisesResults = new ArrayList<>();

  @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
  private List<OksResultEntity> oksResults = new ArrayList<>();

  @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
  private List<Eq5d5lResultEntity> eq5d5lResults = new ArrayList<>();

}
