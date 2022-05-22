package com.kneerecoveryhelper.controller.requests;

import lombok.Data;

@Data
public class ExercisesRequest {

  private String exerciseDate;
  private Boolean firstExercise = false;
  private Boolean secondExercise = false;
  private Boolean thirdExercise = false;
  private Boolean fourthExercise = false;
  private Boolean fifthExercise = false;
  private Boolean sixthExercise = false;
  private Boolean seventhExercise = false;


}
