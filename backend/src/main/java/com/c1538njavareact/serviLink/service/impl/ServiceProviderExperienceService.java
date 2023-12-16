package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.exception.IntegrityValidation;
import com.c1538njavareact.serviLink.model.dto.*;
import com.c1538njavareact.serviLink.model.entity.ServiceProvider;
import com.c1538njavareact.serviLink.model.entity.ServiceProviderExperience;
import com.c1538njavareact.serviLink.repository.IServiceProviderExperienceRepository;
import com.c1538njavareact.serviLink.repository.IServiceProviderRepository;
import com.c1538njavareact.serviLink.service.IServiceProviderExperienceService;
import com.c1538njavareact.serviLink.utils.FileImageFormatUtil;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceProviderExperienceService implements IServiceProviderExperienceService {

    @Autowired
    private IServiceProviderExperienceRepository serviceProviderExperienceRepository;

    @Autowired
    private IServiceProviderRepository serviceProviderRepository;

    @Autowired
    private Cloudinary cloudinary;

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
            (ServiceProviderExperienceDataCreate serviceProviderExperience, UriComponentsBuilder uriComponentsBuilder,
             MultipartFile imageFile) throws IOException {
        if (serviceProviderRepository.findById(serviceProviderExperience.idServiceProvider()).isEmpty()) {
            throw new IntegrityValidation("This provider ID does not was found");
        }
        ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceProviderExperience.idServiceProvider()).get();
        Map imageCreated = null;
        if (imageFile != null) {
            if (FileImageFormatUtil.isFileImageFormat(imageFile)) {
                imageCreated = new HashMap(uploadImage(imageFile));
            } else {
                throw new IntegrityValidation("Only accept image files!");
            }
        }
        ServiceProviderExperience saveServiceProviderExperience = new ServiceProviderExperience(
                imageCreated.get("secure_url").toString(), imageCreated.get("public_id").toString(),
                serviceProviderExperience.altText(), serviceProviderExperience.experienceDescription(), serviceProvider);
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

    private Map uploadImage(MultipartFile imageFile) {
        try {
            return this.cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.asMap(
                    "folder", "servilink/service-provider-experience/"));
        } catch (IOException e) {
            throw new RuntimeException("Image uploading failed!");
        }
    }
}
