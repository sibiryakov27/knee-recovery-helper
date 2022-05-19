package com.kneerecoveryhelper.controller.requests;

import java.util.List;
import lombok.Data;

@Data
public class OksRequest {

  private String passageDate;
  private List<Integer> questions;

}
