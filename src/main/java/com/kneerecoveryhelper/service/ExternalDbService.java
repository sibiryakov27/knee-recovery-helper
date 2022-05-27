package com.kneerecoveryhelper.service;

import com.kneerecoveryhelper.entity.PatientEntity;
import com.kneerecoveryhelper.entity.Roles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExternalDbService {

  private List<PatientEntity> fakePatientsFromExternalDb;

  public ExternalDbService() {
    fakePatientsFromExternalDb = new ArrayList<>();
    PatientEntity patient = new PatientEntity()
        .setMedicalCardNumber("123321123")
        .setStartRecoveryDate(new Date());
    patient
        .setFirstName("Иван")
        .setSecondName("Иванов")
        .setPatronymic("Иванович")
        .setEmail("ivan.sibiriakow@yandex.ru")
        .setPhoneNumber("+71234567890")
        .setPassword("qwe123")
        .setEnabled(true)
        .setRoles(Collections.singleton(Roles.PATIENT))
        .setId(2);

    fakePatientsFromExternalDb.add(patient);
  }

  public PatientEntity getPatientByMedicalCardNumber(String medNumber) {
    return fakePatientsFromExternalDb.get(0);
  }
}
