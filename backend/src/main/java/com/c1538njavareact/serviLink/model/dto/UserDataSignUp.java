package com.c1538njavareact.serviLink.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDataSignUp(

        @NotBlank
        String firstName,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password) {
}
