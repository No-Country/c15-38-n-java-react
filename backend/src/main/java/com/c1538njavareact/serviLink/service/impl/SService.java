package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.model.dto.ServiceDataResponse;
import com.c1538njavareact.serviLink.repository.IServiceRepository;
import com.c1538njavareact.serviLink.service.ISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SService implements ISService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<ServiceDataResponse>> getAllServices() {
        return ResponseEntity.ok(serviceRepository.findAll().stream()
                .map(service -> ServiceDataResponse.builder()
                        .service(service.getName())
                        .build())
                .toList());
    }
}
