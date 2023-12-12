package com.c1538njavareact.serviLink.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDataLogin(Long id, @Email @NotBlank String username, @NotBlank String password) {
}
