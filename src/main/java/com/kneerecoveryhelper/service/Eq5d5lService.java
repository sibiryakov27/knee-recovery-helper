package com.kneerecoveryhelper.service;

import com.kneerecoveryhelper.controller.requests.Eq5d5lRequest;
import com.kneerecoveryhelper.entity.Eq5d5lResultEntity;
import com.kneerecoveryhelper.entity.PatientEntity;
import com.kneerecoveryhelper.repository.Eq5d5lRepository;
import com.kneerecoveryhelper.repository.PatientRepository;
import com.kneerecoveryhelper.util.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Eq5d5lService {

  private Eq5d5lRepository eq5d5lRepository;
  private PatientRepository patientRepository;
  private ModelMapper modelMapper;

  public Eq5d5lResultEntity saveTestResult(Eq5d5lRequest eq5d5lRequest, Integer id)
      throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Date date = dateFormat.parse(eq5d5lRequest.getPassageDate());
    PatientEntity patient = patientRepository.getById(id);
    Integer weekNumber = Util.getWeekDifferencesInDates(patient.getStartRecoveryDate(), date);

    Optional<Eq5d5lResultEntity> eq5d5lResult = eq5d5lRepository.findByWeekNumber(weekNumber);
    if (eq5d5lResult.isEmpty()) {
      Eq5d5lResultEntity newEq5d5lResult = modelMapper.map(eq5d5lRequest, Eq5d5lResultEntity.class);
      newEq5d5lResult
          .setPatient(patient)
          .setPassageDate(date)
          .setWeekNumber(weekNumber);

      return eq5d5lRepository.save(newEq5d5lResult);
    } else {
      Eq5d5lResultEntity updatedEq5d5lResult = eq5d5lResult.get();
      updatedEq5d5lResult
          .setAnxiety(eq5d5lRequest.getAnxiety())
          .setMobility(eq5d5lRequest.getMobility())
          .setPain(eq5d5lRequest.getPain())
          .setSelfCare(eq5d5lRequest.getSelfCare())
          .setUsualActivities(eq5d5lRequest.getUsualActivities())
          .setHealth(eq5d5lRequest.getHealth());
      return eq5d5lRepository.save(updatedEq5d5lResult);
    }
  }

}
