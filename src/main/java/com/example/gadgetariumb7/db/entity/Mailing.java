package com.example.gadgetariumb7.db.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "mailings")
@Getter
@Setter
@NoArgsConstructor
public class Mailing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mailing_gen")
    @SequenceGenerator(name = "mailing_gen", sequenceName = "mailing_seq", allocationSize = 1)
    private Long id;

    private String mailingName;

    private String description;

    private String image;

    private LocalDate mailingDateOfStart;

    private LocalDate mailingDateOfEnd;
}
