package com.kneerecoveryhelper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "eq5d5l_result")
@Getter
@Setter
@Accessors(chain = true)
public class Eq5d5lResultEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column()
  private Integer mobility;

  @Column(name = "self_care")
  private Integer selfCare;

  @Column(name = "usual_activities")
  private Integer usualActivities;

  @Column
  private Integer pain;

  @Column
  private Integer anxiety;

  @Column
  private Integer health;

  @Column(name = "passage_date", columnDefinition = "DATE")
  private Date passageDate;

  @Column(name = "week_number")
  private Integer weekNumber;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "patient_id")
  private PatientEntity patient;

}
