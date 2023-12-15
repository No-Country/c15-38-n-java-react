package com.c1538njavareact.serviLink.controller.impl;

import com.c1538njavareact.serviLink.controller.IServiceProviderExperienceController;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataCreate;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataList;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataResponse;
import com.c1538njavareact.serviLink.service.IServiceProviderExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import static com.c1538njavareact.serviLink.config.ApiConstants.SERVICE_PROVIDER_EXPERIENCE_URI;

@RestController
@RequestMapping(SERVICE_PROVIDER_EXPERIENCE_URI)
@CrossOrigin(origins = "*")
public class ServiceProviderExperienceController implements IServiceProviderExperienceController {

    @Autowired
    private IServiceProviderExperienceService serviceProviderExperience;

    @Override
    public ResponseEntity<ServiceProviderExperienceDataResponse> getById(Long id) {
        return serviceProviderExperience.getById(id);
    }

    @Override
    public ResponseEntity<Page<ServiceProviderExperienceDataList>> getByIdServiceProvider(Long id, Pageable pagination) {
        return serviceProviderExperience.getByIdServiceProvider(id, pagination);
    }

    @Override
    public ResponseEntity<ServiceProviderExperienceDataResponse> createdServiceProviderExperience
            (ServiceProviderExperienceDataCreate serviceProviderExperienceDataCreate, UriComponentsBuilder uriComponentsBuilder) {
        return serviceProviderExperience
                .createdServiceProviderExperience(serviceProviderExperienceDataCreate, uriComponentsBuilder);
    }
}
