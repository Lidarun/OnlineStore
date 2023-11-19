package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.PdfService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pdf")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Pdf API")
public class PdfController {

    private final PdfService pdfService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<InputStreamResource> createPdf(@RequestParam Long subproductId) {
        return pdfService.createPdf(subproductId);
    }

}
