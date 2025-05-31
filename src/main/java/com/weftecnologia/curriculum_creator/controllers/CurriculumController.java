package com.weftecnologia.curriculum_creator.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weftecnologia.curriculum_creator.entities.Curriculum;
import com.weftecnologia.curriculum_creator.services.CurriculumService;

@RestController
@RequestMapping("/api")
public class CurriculumController {
  
  private final CurriculumService curriculumService;

  public CurriculumController(CurriculumService curriculumService) {
    this.curriculumService = curriculumService;
  }

  @PostMapping("/view")
  public ResponseEntity<String> generate(@RequestBody Curriculum curriculum) {
    try {
      String template = curriculumService.generateHtmlFromCurriculum(curriculum);
      return ResponseEntity.ok(template); 
    } catch (IOException err) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Failed to generate HTML, error: " + err);
    }
  }

  @GetMapping
  public Map<String, Object> getBody() {
    return Map.of(
      "name", "",
      "city", "",
      "number", "",
      "email", "",
      "aboutMe", "",
      "workExperience", List.of(Map.of(
              "company", "",
              "cargo", "",
              "workPeriod", "",
              "description", ""
      )),
      "skills", List.of(Map.of("description", "")),
      "objective", List.of(Map.of("description", ""))
    );
  } 
}
