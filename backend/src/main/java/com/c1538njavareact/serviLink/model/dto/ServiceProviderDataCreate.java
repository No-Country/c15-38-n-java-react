package com.c1538njavareact.serviLink.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public record ServiceProviderDataCreate(
        @NotNull
        Long idProvider,
        @NotNull
        Long idService,
        String description,
        @NumberFormat
        BigDecimal price

) {
}
