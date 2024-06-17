package com.project.cafe.controller;

import com.project.cafe.dto.CafeDTO;
import com.project.cafe.service.CafeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cafe")
@Validated
@Log4j2


public class CafeController {
  private final CafeService cafeService;

  @Autowired
  public CafeController(CafeService cafeService) {
    this.cafeService = cafeService;
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerMember(@Valid @RequestBody CafeDTO cafeDTO) {
    try {
      cafeService.registerMember(cafeDTO);
      return new ResponseEntity<>("Member registered successfully", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>("Error occurred while registering member", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
