package com.kneerecoveryhelper.controller;

import com.kneerecoveryhelper.entity.UserEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlPagesController {

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
    model.addAttribute("user", user);
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
