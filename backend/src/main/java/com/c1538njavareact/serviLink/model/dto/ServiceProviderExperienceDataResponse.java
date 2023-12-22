package com.c1538njavareact.serviLink.model.dto;

import lombok.Builder;

public record ServiceProviderExperienceDataResponse
        (Long id, String imageUrl, String altText, String experienceDescription, ServiceProviderData serviceProviderData) {
}
