package com.kneerecoveryhelper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlPagesController {

  @RequestMapping("/")
  public String showIndexPage() {
    return "index";
  }

  @RequestMapping("/about-system")
  public String showAboutIndexPage() {
    return "about-system";
  }

  @RequestMapping("/exercises")
  public String showExercisesPage() {
    return "exercises";
  }

  @RequestMapping("/profile")
  public String showProfilePage() {
    return "profile";
  }

  @RequestMapping("/test-eq5d3l")
  public String showTestEQ5D3LPage() {
    return "test-eq-5d-3l";
  }

  @RequestMapping("/test-oks")
  public String showTestOKS() {
    return "test-oks";
  }

}
