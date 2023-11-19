package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.entity.Subproduct;
import com.example.gadgetariumb7.db.repository.SubproductRepository;
import com.example.gadgetariumb7.db.service.PdfService;
import com.example.gadgetariumb7.exceptions.NotFoundException;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class PdfServiceImpl implements PdfService {
    private final SubproductRepository subproductRepository;
    @Value("${google.cloud.apiKey}")
    private String googleAPI;

    @Override
    public ResponseEntity<InputStreamResource> createPdf(Long subproductId) {
        Subproduct subproduct = subproductRepository.findById(subproductId).orElseThrow(() -> {
            log.error("Subproduct not found");
            throw new NotFoundException("Subproduct not found");
        });
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);

        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
        Font nameFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15);
        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 14);

        Paragraph titleParagraph = new Paragraph("Gadgetarium STORE", titleFont);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(titleParagraph);

        Paragraph nameParagraph = new Paragraph("Характеристики " + subproduct.getProduct().getProductName() + ": ", nameFont);
        titleParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(nameParagraph);

        subproduct.getCharacteristics().forEach((key, value) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (Character.isUpperCase(c)) {
                    stringBuilder.append(" ").append(Character.toLowerCase(c));
                } else {
                    stringBuilder.append(c);
                }
            }
            String characteristic = stringBuilder + ": " + value;
            Paragraph paragraph = new Paragraph(characteristic, paragraphFont);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);
        });

        document.close();

        ByteArrayInputStream pdf = new ByteArrayInputStream(out.toByteArray());
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Content-Disposition", "inline;file=lcwd.pdf");
        log.info("successfully works create pdf method");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
