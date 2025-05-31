package com.weftecnologia.curriculum_creator.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.weftecnologia.curriculum_creator.entities.Curriculum;

@Service
public class CurriculumService {

  public String generateHtmlFromCurriculum(Curriculum curriculum) throws IOException {
    String template = this.loadHtmlTemplate("curriculum-template.html");

    String workExperienceHtml = curriculum.getWorkExperience().stream()
      .map(we -> "<li>" + "<strong>" + we.getCompany() +  we.getWorkPeriod() + "</strong><br/>" + we.getCargo() + "<br/>" + we.getDescription() + "</li>")
      .collect(Collectors.joining());

    String skillsHtml = curriculum.getSkills().stream()
      .map(s -> "<li>" + s.getDescription() + "</li>" )
      .collect(Collectors.joining());

    String objectiveHtml = curriculum.getObjective().stream()
      .map(o -> "<li>" + o.getDescription() + "</li>")  
      .collect(Collectors.joining());

      return template
        .replace("{{name}}", curriculum.getName())
        .replace("{{city}}", curriculum.getCity())
        .replace("{{email}}", curriculum.getEmail())
        .replace("{{number}}", curriculum.getNumber())
        .replace("{{aboutMe}}", curriculum.getAboutMe())
        .replace("{{workExperience}}", workExperienceHtml)
        .replace("{{skills}}", skillsHtml)
        .replace("{{objective}}", objectiveHtml);
  }

  private String loadHtmlTemplate(String filename) throws IOException {
    ClassPathResource resource = new ClassPathResource("templates/" + filename);
    return new String (resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
  }
}
