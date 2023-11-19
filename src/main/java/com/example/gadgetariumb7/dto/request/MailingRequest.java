package com.example.gadgetariumb7.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailingRequest {
    private String mailingName;

    private String description;

    private String image;

    private LocalDate mailingDateOfStart;

    private LocalDate mailingDateOfEnd;
}
