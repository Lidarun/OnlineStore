package com.example.gadgetariumb7.db.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

public interface PdfService {

    ResponseEntity<InputStreamResource> createPdf(Long subproductId);

}