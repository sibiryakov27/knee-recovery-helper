package com.kneerecoveryhelper.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {

  PATIENT;

  @Override
  public String getAuthority() {
    return name();
  }
}
