package com.example.gadgetariumb7.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String image;
}
