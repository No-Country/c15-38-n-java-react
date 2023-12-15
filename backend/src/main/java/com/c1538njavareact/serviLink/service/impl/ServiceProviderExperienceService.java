package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.exception.IntegrityValidation;
import com.c1538njavareact.serviLink.model.dto.*;
import com.c1538njavareact.serviLink.model.entity.ServiceProvider;
import com.c1538njavareact.serviLink.model.entity.ServiceProviderExperience;
import com.c1538njavareact.serviLink.repository.IServiceProviderExperienceRepository;
import com.c1538njavareact.serviLink.repository.IServiceProviderRepository;
import com.c1538njavareact.serviLink.service.IServiceProviderExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ServiceProviderExperienceService implements IServiceProviderExperienceService {

    @Autowired
    private IServiceProviderExperienceRepository serviceProviderExperienceRepository;

    @Autowired
    private IServiceProviderRepository serviceProviderRepository;

    @Override
    public ResponseEntity<ServiceProviderExperienceDataResponse> getById(Long id) {
        ServiceProviderExperience serviceProviderExperience = serviceProviderExperienceRepository.findById(id).get();
        return ResponseEntity.ok(generateServiceProviderExperienceDataResponse(serviceProviderExperience));
    }

    @Override
    public ResponseEntity<Page<ServiceProviderExperienceDataList>> getByIdServiceProvider(Long id, Pageable pagination) {
        Page<ServiceProviderExperience> serviceProviderExperiences = serviceProviderExperienceRepository.findByServicesProviderId(id, pagination);
        return ResponseEntity.ok(serviceProviderExperiences.map(ServiceProviderExperienceDataList::new));
    }

    @Override
    public ResponseEntity<ServiceProviderExperienceDataResponse> createdServiceProviderExperience
            (ServiceProviderExperienceDataCreate serviceProviderExperience, UriComponentsBuilder uriComponentsBuilder) {
        if ( serviceProviderRepository.findById(serviceProviderExperience.idServiceProvider()).isEmpty() ){
            throw new IntegrityValidation("This provider ID does not was found");
        }
        ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceProviderExperience.idServiceProvider()).get();
        ServiceProviderExperience saveServiceProviderExperience = new ServiceProviderExperience
                (serviceProviderExperience.imageUrl(), serviceProviderExperience.altText(),
                        serviceProviderExperience.experienceDescription(), serviceProvider);
        serviceProviderExperienceRepository.save(saveServiceProviderExperience);
        URI url = uriComponentsBuilder.path("/service-provider-experience/{id}")
                .buildAndExpand(saveServiceProviderExperience.getId()).toUri();
        return ResponseEntity.created(url).body(generateServiceProviderExperienceDataResponse(saveServiceProviderExperience));
    }

    private ServiceProviderExperienceDataResponse generateServiceProviderExperienceDataResponse
            (ServiceProviderExperience serviceProviderExperience){
        return new ServiceProviderExperienceDataResponse(serviceProviderExperience.getId(),
                serviceProviderExperience.getImageUrl(), serviceProviderExperience.getAltText(),
                serviceProviderExperience.getExperienceDescription(),
                new ServiceProviderData(serviceProviderExperience.getServicesProvider().getId(),
                        new ProviderDataGetOne(serviceProviderExperience.getServicesProvider().getProvider().getFirstName(),
                                serviceProviderExperience.getServicesProvider().getProvider().getLastName(),
                                serviceProviderExperience.getServicesProvider().getProvider().getEmail(),
                                serviceProviderExperience.getServicesProvider().getProvider().getPhoneNumber(),
                                serviceProviderExperience.getServicesProvider().getProvider().getProfileImageUrl()
                        ),
                        new com.c1538njavareact.serviLink.model.entity.Service(serviceProviderExperience.getServicesProvider().getService().getId(),
                                serviceProviderExperience.getServicesProvider().getService().getName()
                        ),
                        serviceProviderExperience.getServicesProvider().getDescription(), serviceProviderExperience.getServicesProvider().getPrice())
                );
    }
}
