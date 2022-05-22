package com.kneerecoveryhelper.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "exercises_status")
@Getter
@Setter
@Accessors(chain = true)
public class ExercisesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "first_exercise")
  private Boolean firstExercise;

  @Column(name = "second_exercise")
  private Boolean secondExercise;

  @Column(name = "third_exercise")
  private Boolean thirdExercise;

  @Column(name = "fourth_exercise")
  private Boolean fourthExercise;

  @Column(name = "fifth_exercise")
  private Boolean fifthExercise;

  @Column(name = "sixth_exercise")
  private Boolean sixthExercise;

  @Column(name = "seventh_exercise")
  private Boolean seventhExercise;

  @Column(name = "exercise_date", columnDefinition = "DATE")
  private Date exerciseDate;

  @Column(name = "week_number")
  private Integer weekNumber;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "patient_id")
  private PatientEntity patient;

}
