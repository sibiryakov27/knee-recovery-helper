package com.kneerecoveryhelper.controller;

import com.kneerecoveryhelper.controller.requests.Eq5d5lRequest;
import com.kneerecoveryhelper.controller.requests.ExercisesRequest;
import com.kneerecoveryhelper.controller.requests.OksRequest;
import com.kneerecoveryhelper.service.Eq5d5lService;
import com.kneerecoveryhelper.service.ExercisesService;
import com.kneerecoveryhelper.service.ExternalDbService;
import com.kneerecoveryhelper.service.OksService;
import com.kneerecoveryhelper.service.PatientService;
import com.kneerecoveryhelper.controller.requests.PatientRequest;
import com.kneerecoveryhelper.entity.PatientEntity;
import com.kneerecoveryhelper.entity.UserEntity;
import java.text.ParseException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@AllArgsConstructor
public class MainController {

  private PatientService patientService;
  private OksService oksService;
  private Eq5d5lService eq5d5lService;
  private ExercisesService exercisesService;
  private ExternalDbService externalDbService;

  @GetMapping("/")
  public String showIndexPage() {
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/registration")
  public String registration() {
    return "/registration";
  }

  @PostMapping("/registration")
  public String addPatient(String medicalCardNumber) {
    PatientEntity patient = externalDbService.getPatientByMedicalCardNumber(medicalCardNumber);
    patientService.savePatient(patient);
    return "redirect:/login";
  }

  @GetMapping("/about-system")
  public String showAboutIndexPage() {
    return "about-system";
  }

  @GetMapping("/exercises")
  public String showExercisesPage(
      @AuthenticationPrincipal UserEntity user,
      Model model
  ) {
    PatientEntity patient = patientService.getPatientById(user.getId());
    model.addAttribute("patient", patient);
    return "exercises";
  }

  @GetMapping("/profile")
  public String showProfilePage(
      @AuthenticationPrincipal UserEntity user,
      Model model
  ) {
    PatientEntity patient = patientService.getPatientById(user.getId());
    model.addAttribute("patient", patient);
    return "profile";
  }

  @GetMapping("/test-eq5d5l")
  public String showTestEQ5D3LPage(
      @AuthenticationPrincipal UserEntity user,
      Model model
  ) {
    PatientEntity patient = patientService.getPatientById(user.getId());
    model.addAttribute("patient", patient);
    return "test-eq-5d-5l";
  }

  @GetMapping("/test-oks")
  public String showTestOKS(
      @AuthenticationPrincipal UserEntity user,
      Model model
  ) {
    PatientEntity patient = patientService.getPatientById(user.getId());
    model.addAttribute("patient", patient);
    return "test-oks";
  }

  @PutMapping("/profile/{id}/update")
  public String updatePatient(
      @PathVariable Integer id,
      PatientRequest patientRequest,
      @AuthenticationPrincipal UserEntity user,
      Model model
  ) {
    PatientEntity patient = patientService.updatePatient(patientRequest, id);
    model.addAttribute("patient", patient);
    return "redirect:/profile";
  }

  @PostMapping("/test-oks/{id}/save")
  public String saveOksResult(
      @PathVariable Integer id,
      OksRequest oksRequest,
      Model model
  ) throws ParseException {
    oksService.saveTestResult(oksRequest, id);
    return "redirect:/test-oks";
  }

  @PostMapping("/test-eq5d5l/{id}/save")
  public String saveEq5d3lResult(
      @PathVariable Integer id,
      Eq5d5lRequest eq5d5lRequest,
      Model model
  ) throws ParseException {
    eq5d5lService.saveTestResult(eq5d5lRequest, id);
    return "redirect:/test-eq5d5l";
  }

  @PostMapping("exercises/{id}/save")
  public String saveExercisesResult(
      @PathVariable Integer id,
      ExercisesRequest exercisesRequest,
      Model model
  ) throws ParseException {
    exercisesService.saveExercisesResult(exercisesRequest, id);
    return "redirect:/exercises";
  }

}
