package com.kneerecoveryhelper.Service;

import com.kneerecoveryhelper.controller.requests.PatientRequest;
import com.kneerecoveryhelper.entity.PatientEntity;
import com.kneerecoveryhelper.repository.PatientRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {

  private PatientRepository patientRepository;
  private ModelMapper modelMapper;

  public PatientEntity getPatientById(Integer id) {
    Optional<PatientEntity> patient = patientRepository.findById(id);
    return patient.get(); // TODO: added checking optional
  }

  public PatientEntity updatePatient(PatientRequest patientRequest, Integer id) {
    PatientEntity patient = modelMapper.map(patientRequest, PatientEntity.class);
    PatientEntity updatedPatient = patientRepository.getById(id);
    patient.setId(id);
    patient.setPassword(updatedPatient.getPassword());
    patient.setEnabled(updatedPatient.getEnabled());
    patient.setRoles(updatedPatient.getRoles());
    updatedPatient = patientRepository.save(patient);
    return updatedPatient;
  }

}
