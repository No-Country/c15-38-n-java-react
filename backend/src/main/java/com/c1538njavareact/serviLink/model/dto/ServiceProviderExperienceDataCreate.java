package com.c1538njavareact.serviLink.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServiceProviderExperienceDataCreate(
        @NotNull
        Long idServiceProvider,
        String altText,
        @NotBlank
        String experienceDescription,
        @NotBlank
        String imageUrl
) {
}
