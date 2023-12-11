package com.c1538njavareact.serviLink.model.dto;

import com.c1538njavareact.serviLink.model.entity.Provider;
import com.c1538njavareact.serviLink.model.entity.Service;

import java.math.BigDecimal;

public record ServiceProviderData(Long id, Provider provider, Service service, String description, BigDecimal price) {
}
