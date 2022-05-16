package com.kneerecoveryhelper.entity;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class PatientEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "second_name")
  private String secondName;

  @Column
  private String patronymic;

  @Column
  private String email;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "medical_card_number")
  private String medicalCardNumber;

  @Column
  private String password;

  @Column
  private Boolean enabled;

  @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "id"))
  @Enumerated(EnumType.STRING)
  private Set<Roles> roles;
}
