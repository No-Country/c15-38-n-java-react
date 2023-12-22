package com.c1538njavareact.serviLink.model.dto;

import jakarta.validation.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

public record ProviderDataUpdate(String firstName, String lastName, String phoneNumber, MultipartFile imageFile) {
}
