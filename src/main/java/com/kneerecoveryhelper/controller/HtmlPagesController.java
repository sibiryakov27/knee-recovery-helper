package com.kneerecoveryhelper.controller;

import com.kneerecoveryhelper.Service.PatientService;
import com.kneerecoveryhelper.entity.PatientEntity;
import com.kneerecoveryhelper.entity.UserEntity;
import com.kneerecoveryhelper.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HtmlPagesController {

  private PatientService patientService;

  @GetMapping("/")
  public String showIndexPage() {
    return "index";
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
  public String showTestEQ5D3LPage() {
    return "test-eq-5d-3l";
  }

  @GetMapping("/test-oks")
  public String showTestOKS() {
    return "test-oks";
  }

}
