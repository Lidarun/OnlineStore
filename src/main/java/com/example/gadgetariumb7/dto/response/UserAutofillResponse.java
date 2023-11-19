package com.example.gadgetariumb7.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserAutofillResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
}
