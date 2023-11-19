package com.example.gadgetariumb7.dto.request;

import com.example.gadgetariumb7.validation.phoneNumber.PhoneValid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    @NotNull(message = "First name should be not null")
    @Size(min = 2, max = 25)
    private String firstName;

    @Size(min = 2, max = 25)
    @NotNull(message = "Last name should be not null")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email should be not null")
    @NotBlank(message = "Email should not be empty")
    private String email;

    @PhoneValid(message = "Phone should be valid")
    private String phoneNumber;

    private String image;

    private String address;
}
