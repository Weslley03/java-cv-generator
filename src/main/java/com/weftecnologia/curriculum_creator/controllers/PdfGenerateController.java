package com.weftecnologia.curriculum_creator.controllers;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weftecnologia.curriculum_creator.entities.Curriculum;
import com.weftecnologia.curriculum_creator.services.CurriculumService;
import com.weftecnologia.curriculum_creator.services.PdfGenerateService;

@RestController
@RequestMapping("/api/pdf")
public class PdfGenerateController {
  
  private final PdfGenerateService pdfGenerateService;
  private final CurriculumService curriculumService;

  public PdfGenerateController(PdfGenerateService pdfGenerateService, CurriculumService curriculumService) {
    this.pdfGenerateService = pdfGenerateService;
    this.curriculumService = curriculumService;
  }

  @PostMapping
  public ResponseEntity<byte[]> generatePdf(@RequestBody Curriculum curriculum) {
    try {
      String html = curriculumService.generateHtmlFromCurriculum(curriculum);
      byte[] pdfBytes = pdfGenerateService.generatePdfFromHtml(html);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_PDF);
      headers.setContentDispositionFormData("attachment", "curriculum.pdf");

      return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    } catch (IOException err) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }
}
