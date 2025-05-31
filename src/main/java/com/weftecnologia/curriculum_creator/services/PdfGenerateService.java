package com.weftecnologia.curriculum_creator.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@Service
public class PdfGenerateService {
  public byte[] generatePdfFromHtml(String htmlContent) {
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      PdfRendererBuilder builder = new PdfRendererBuilder();
      builder.useFastMode();
      builder.withHtmlContent(htmlContent, null);
      builder.toStream(outputStream);
      builder.run();

      return outputStream.toByteArray();      
    } catch (IOException err) {
      throw new RuntimeException("Failed to generate PDF", err);
    }
  }
}
