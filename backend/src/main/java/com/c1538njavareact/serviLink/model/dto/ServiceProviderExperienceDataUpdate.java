package com.c1538njavareact.serviLink.model.dto;

import org.springframework.web.multipart.MultipartFile;

public record ServiceProviderExperienceDataUpdate(String altText, String experienceDescription, MultipartFile imageFile) {
}
