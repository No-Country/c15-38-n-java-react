package com.c1538njavareact.serviLink.model.dto;

import jakarta.validation.constraints.Email;

public record ProviderDataUpdate(String firstName, String lastName, @Email String email, String phoneNumber, String  profileImageUrl) {
}
