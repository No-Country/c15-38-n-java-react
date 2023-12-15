package com.c1538njavareact.serviLink.service;

import com.c1538njavareact.serviLink.model.dto.ServiceProviderData;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderDataCreate;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderDataList;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderDataUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface IServiceProviderService {
    public ResponseEntity<ServiceProviderData> getById(Long id);
    public ResponseEntity<Page<ServiceProviderDataList>> getByIdProvider(Long id, Pageable pagination);
    public ResponseEntity<Page<ServiceProviderDataList>> getByIdService(Long id, Pageable pagination);
    public ResponseEntity<ServiceProviderData> createServiceProvider(ServiceProviderDataCreate serviceProviderDataCreate, UriComponentsBuilder uriComponentsBuilder);
    public ResponseEntity<ServiceProviderData> updateServiceProvider(Long id, ServiceProviderDataUpdate serviceProviderDataUpdate);
    public ResponseEntity deleteServiceProvider(Long id);

}
