package com.kneerecoveryhelper.Service;

import com.kneerecoveryhelper.entity.PatientEntity;
import com.kneerecoveryhelper.repository.PatientRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {

  private PatientRepository patientRepository;

  public PatientEntity getPatientById(Integer id) {
    Optional<PatientEntity> patient = patientRepository.findById(id);
    return patient.get(); // TODO: added checking optional
  }

}
