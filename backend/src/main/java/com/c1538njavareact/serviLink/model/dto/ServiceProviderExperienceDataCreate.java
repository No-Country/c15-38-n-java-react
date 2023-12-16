package com.c1538njavareact.serviLink.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record ServiceProviderExperienceDataCreate(
        @NotNull
        Long idServiceProvider,
        String altText,
        @NotBlank
        String experienceDescription,
        MultipartFile imageFile
) {
}
