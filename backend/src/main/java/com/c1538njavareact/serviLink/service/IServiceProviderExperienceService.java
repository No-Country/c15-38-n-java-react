package com.c1538njavareact.serviLink.service;

import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataCreate;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataList;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

public interface IServiceProviderExperienceService {

    ResponseEntity<ServiceProviderExperienceDataResponse> getById(Long id);

    ResponseEntity<Page<ServiceProviderExperienceDataList>> getByIdServiceProvider(Long id, Pageable pagination);

    ResponseEntity<ServiceProviderExperienceDataResponse> createdServiceProviderExperience
            (ServiceProviderExperienceDataCreate serviceProviderExperience, UriComponentsBuilder uriComponentsBuilder,
             MultipartFile imageFile) throws IOException;

}
