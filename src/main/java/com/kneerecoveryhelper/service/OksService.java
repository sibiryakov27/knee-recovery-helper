package com.kneerecoveryhelper.service;

import com.kneerecoveryhelper.controller.requests.TestResult;
import com.kneerecoveryhelper.entity.OksQuestionResultEntity;
import com.kneerecoveryhelper.entity.OksResultEntity;
import com.kneerecoveryhelper.entity.PatientEntity;
import com.kneerecoveryhelper.repository.OksQuestionRepository;
import com.kneerecoveryhelper.repository.OksRepository;
import com.kneerecoveryhelper.repository.PatientRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OksService {

  private OksRepository oksRepository;
  private PatientRepository patientRepository;
  private OksQuestionRepository oksQuestionRepository;

  public OksResultEntity saveTestResult(TestResult testResult, Integer id) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Date date = dateFormat.parse(testResult.getPassageDate());
    Integer points = getOksPoints(testResult);
    PatientEntity patient = patientRepository.getById(id);

    Optional<OksResultEntity> oksResult = oksRepository.findByPassageDate(date);
    if (oksResult.isEmpty()) {
      OksResultEntity newOksResult = new OksResultEntity();
      List<OksQuestionResultEntity> questionsResult = getQuestionsResult(testResult, newOksResult);
      Integer diffInWeeks = getWeekDifferencesInDates(patient.getStartRecoveryDate(), date);

      newOksResult
          .setPatient(patient)
          .setPassageDate(date)
          .setPoints(points)
          .setQuestionsResult(questionsResult)
          .setWeekNumber(diffInWeeks);

      return oksRepository.save(newOksResult);
    } else {
      OksResultEntity updatedOksResult = oksResult.get();
      List<OksQuestionResultEntity> questionsResult = updateQuestionsResult(testResult, updatedOksResult);
      updatedOksResult
          .setPoints(points)
          .setQuestionsResult(questionsResult);

      return oksRepository.save(updatedOksResult);
    }
  }

  private Integer getOksPoints(TestResult testResult) {
    Integer points = 0;
    for (Integer point : testResult.getQuestions()) {
      points += point;
    }

    return points;
  }

  private List<OksQuestionResultEntity> getQuestionsResult(TestResult testResult, OksResultEntity resultEntity) {
    List<OksQuestionResultEntity> questionsResult = new ArrayList<>();
    for (int i = 0; i < testResult.getQuestions().size(); i++) {
      OksQuestionResultEntity oksQuestionResult = new OksQuestionResultEntity();
      oksQuestionResult
          .setQuestionNumber(i + 1)
          .setPoints(testResult.getQuestions().get(i))
              .setOksResult(resultEntity);

      questionsResult.add(oksQuestionResult);
    }

    return questionsResult;
  }

  private List<OksQuestionResultEntity> updateQuestionsResult(TestResult testResult, OksResultEntity oksResult) {
    List<OksQuestionResultEntity> questionsResult = oksQuestionRepository.getAllByOksResultOrderByQuestionNumber(oksResult);
    for (int i = 0; i < questionsResult.size(); i++) {
      questionsResult.get(i).setPoints(testResult.getQuestions().get(i));
    }

    return questionsResult;
  }

  private Integer getWeekDifferencesInDates(Date firstDate, Date secondDate) {
    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());

    return Math.toIntExact(
        TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 7 + 1);
  }

}
