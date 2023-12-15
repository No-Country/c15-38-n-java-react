package com.c1538njavareact.serviLink.model.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public record ServiceProviderDataUpdate(
        String description,
        @NumberFormat
        BigDecimal price
) {
}
