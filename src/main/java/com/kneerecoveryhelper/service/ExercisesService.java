package com.kneerecoveryhelper.service;

import com.kneerecoveryhelper.controller.requests.ExercisesRequest;
import com.kneerecoveryhelper.entity.ExercisesEntity;
import com.kneerecoveryhelper.entity.PatientEntity;
import com.kneerecoveryhelper.repository.ExercisesRepository;
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
public class ExercisesService {

  private ExercisesRepository exercisesRepository;
  private PatientRepository patientRepository;
  private ModelMapper modelMapper;

  public ExercisesEntity saveExercisesResult(ExercisesRequest exercisesRequest, Integer id)
      throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Date date = dateFormat.parse(exercisesRequest.getExerciseDate());
    PatientEntity patient = patientRepository.getById(id);
    Integer weekNumber = Util.getWeekDifferencesInDates(date, patient.getStartRecoveryDate());

    Optional<ExercisesEntity> exercises = exercisesRepository.findByExerciseDate(date);
    if (exercises.isEmpty()) {
      ExercisesEntity exercisesEntity = modelMapper.map(exercisesRequest, ExercisesEntity.class);
      exercisesEntity
          .setPatient(patient)
          .setExerciseDate(date)
          .setWeekNumber(weekNumber);

      return exercisesRepository.save(exercisesEntity);
    } else {
      ExercisesEntity updatedExercisesEntity = exercises.get();
      updatedExercisesEntity
          .setFirstExercise(exercisesRequest.getFirstExercise())
          .setSecondExercise(exercisesRequest.getSecondExercise())
          .setThirdExercise(exercisesRequest.getThirdExercise())
          .setFourthExercise(exercisesRequest.getFourthExercise())
          .setFifthExercise(exercisesRequest.getFifthExercise())
          .setSixthExercise(exercisesRequest.getSixthExercise())
          .setSeventhExercise(exercisesRequest.getSeventhExercise());

      return exercisesRepository.save(updatedExercisesEntity);
    }
  }

}
