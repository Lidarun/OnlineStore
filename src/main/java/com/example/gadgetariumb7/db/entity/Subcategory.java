package com.example.gadgetariumb7.db.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "subcategories")
@Getter
@Setter
@NoArgsConstructor
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subcategory_gen")
    @SequenceGenerator(name = "subcategory_gen", sequenceName = "subcategory_seq", allocationSize = 1, initialValue = 20)
    private Long id;

    private String subCategoryName;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private Category category;
}
