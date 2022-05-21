package com.kneerecoveryhelper.controller.requests;

import lombok.Data;

@Data
public class Eq5d5lRequest {

  private String passageDate;
  private Integer mobility;
  private Integer selfCare;
  private Integer usualActivities;
  private Integer pain;
  private Integer anxiety;
  private Integer health;

}
