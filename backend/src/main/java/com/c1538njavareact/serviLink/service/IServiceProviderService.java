package com.c1538njavareact.serviLink.service;

import com.c1538njavareact.serviLink.model.dto.ServiceProviderData;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderDataCreate;
import com.c1538njavareact.serviLink.model.entity.ServiceProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface IServiceProviderService {
    public ResponseEntity<ServiceProvider> getById(Long id);
    public ResponseEntity<ServiceProviderData> createServiceProvider(ServiceProviderDataCreate serviceProviderDataCreate, UriComponentsBuilder uriComponentsBuilder);
}
