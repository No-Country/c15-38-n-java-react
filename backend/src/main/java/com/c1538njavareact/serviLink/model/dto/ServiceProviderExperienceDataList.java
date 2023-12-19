package com.c1538njavareact.serviLink.model.dto;

import com.c1538njavareact.serviLink.model.entity.ServiceProviderExperience;
import lombok.Builder;


public record ServiceProviderExperienceDataList(Long id, String imageUrl, String altText, String experienceDescription) {

    public ServiceProviderExperienceDataList(ServiceProviderExperience serviceProviderExperience) {
        this(serviceProviderExperience.getId(), serviceProviderExperience.getImageUrl(),
                serviceProviderExperience.getAltText(), serviceProviderExperience.getExperienceDescription());
    }
}
