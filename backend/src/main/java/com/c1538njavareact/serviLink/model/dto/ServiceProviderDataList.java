package com.c1538njavareact.serviLink.model.dto;

import com.c1538njavareact.serviLink.model.entity.Service;
import com.c1538njavareact.serviLink.model.entity.ServiceProvider;

import java.math.BigDecimal;

public record ServiceProviderDataList(Long id, ProviderDataGetOne providerDataGetOne, Service service, String description, BigDecimal price) {
    public ServiceProviderDataList(ServiceProvider serviceProvider) {
        this(serviceProvider.getId(),
                new ProviderDataGetOne(serviceProvider.getProvider().getFirstName(),
                        serviceProvider.getProvider().getLastName(), serviceProvider.getProvider().getEmail(),
                        serviceProvider.getProvider().getPhoneNumber(), serviceProvider.getProvider().getProfileImageUrl()
                ),
                new Service(serviceProvider.getService().getId(),
                        serviceProvider.getService().getName(), serviceProvider.getService().getServiceCategory()
                ),
                serviceProvider.getDescription(), serviceProvider.getPrice());
    }
}
