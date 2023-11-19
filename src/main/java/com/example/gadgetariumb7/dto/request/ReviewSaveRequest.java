package com.example.gadgetariumb7.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class ReviewSaveRequest {
    @NotNull(message = "Product id should be not null")
    private Long productId;

    @NotNull(message = "Review rating should be not null")
    private Double productGrade;

    @NotNull(message = "Review comment should be not null")
    @NotBlank(message = "Review comment should be not blank")
    private String reviewComment;

    private List<String> images;
}
