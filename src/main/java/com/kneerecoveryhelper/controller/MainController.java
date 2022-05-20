package com.kneerecoveryhelper.controller;

import com.kneerecoveryhelper.controller.requests.TestResult;
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

  @GetMapping("/")
  public String showIndexPage() {
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/about-system")
  public String showAboutIndexPage() {
    return "about-system";
  }

  @GetMapping("/exercises")
  public String showExercisesPage() {
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

  @GetMapping("/test-eq5d3l")
  public String showTestEQ5D3LPage(
      @AuthenticationPrincipal UserEntity user,
      Model model
  ) {
    PatientEntity patient = patientService.getPatientById(user.getId());
    model.addAttribute("patient", patient);
    return "test-eq-5d-3l";
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
      TestResult testResult,
      Model model
  ) throws ParseException {
    oksService.saveTestResult(testResult, id);
    return "redirect:/test-oks";
  }

  @PostMapping("/test-eq5d3l/{id}/save")
  public String saveEq5d3lResult(
      @PathVariable Integer id,
      TestResult testResult,
      Model model
  ) {
    System.out.println(testResult);
    return "redirect:/test-eq5d3l";
  }

}
