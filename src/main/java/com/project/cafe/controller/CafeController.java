package com.project.cafe.controller;

import com.project.cafe.dto.CafeDTO;
import com.project.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@Log4j2
@RequiredArgsConstructor
public class CafeController {

  private final CafeService cafeService;

  @GetMapping("/join")
  public String showJoinForm(Model model) {
    model.addAttribute("cafeDTO", new CafeDTO());
    return "user/join";
  }

  @PostMapping("/join")
  public String registerMember(@ModelAttribute CafeDTO cafeDTO) {
    cafeService.registerMember(cafeDTO);
    return "redirect:/";
  }
}
