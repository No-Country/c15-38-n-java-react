package com.c1538njavareact.serviLink.controller.impl;

import com.c1538njavareact.serviLink.controller.IServiceProviderController;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderData;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderDataCreate;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderDataList;
import com.c1538njavareact.serviLink.service.IServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import static com.c1538njavareact.serviLink.config.ApiConstants.SERVICE_PROVIDER_URI;

@RestController
@RequestMapping(SERVICE_PROVIDER_URI)
public class ServiceProviderController implements IServiceProviderController {
    @Autowired
    IServiceProviderService serviceProviderService;

    @Override
    public ResponseEntity<ServiceProviderData> createServiceProvider(Long id) {
        return serviceProviderService.getById(id);
    }

    @Override
    public ResponseEntity<Page<ServiceProviderDataList>> getByIdProvider(Long id, Pageable pagination) {
        return serviceProviderService.getByIdProvider(id, pagination);
    }

    @Override
    public ResponseEntity<Page<ServiceProviderDataList>> getByIdService(Long id, Pageable pagination) {
        return serviceProviderService.getByIdService(id, pagination);
    }

    @Override
    public ResponseEntity<ServiceProviderData> createServiceProvider(ServiceProviderDataCreate serviceProviderDataCreate, UriComponentsBuilder uriComponentsBuilder) {
        return serviceProviderService.createServiceProvider(serviceProviderDataCreate, uriComponentsBuilder);
    }
}
