package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.exception.IntegrityValidation;
import com.c1538njavareact.serviLink.model.dto.*;
import com.c1538njavareact.serviLink.model.entity.ServiceProvider;
import com.c1538njavareact.serviLink.model.entity.ServiceProviderExperience;
import com.c1538njavareact.serviLink.repository.IServiceProviderExperienceRepository;
import com.c1538njavareact.serviLink.repository.IServiceProviderRepository;
import com.c1538njavareact.serviLink.service.IServiceProviderExperienceService;
import com.c1538njavareact.serviLink.utils.IUploadImage;
import com.c1538njavareact.serviLink.utils.MethodsUtil;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceProviderExperienceService implements IServiceProviderExperienceService, IUploadImage {

    @Autowired
    private IServiceProviderExperienceRepository serviceProviderExperienceRepository;

    @Autowired
    private IServiceProviderRepository serviceProviderRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<ServiceProviderExperienceDataResponse> getById(Long id) {
        ServiceProviderExperience serviceProviderExperience = serviceProviderExperienceRepository.findById(id).get();
        return ResponseEntity.ok(generateServiceProviderExperienceDataResponse(serviceProviderExperience));
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<Page<ServiceProviderExperienceDataList>> getByIdServiceProvider(Long id, Pageable pagination) {
        Page<ServiceProviderExperience> serviceProviderExperiences = serviceProviderExperienceRepository.findByServicesProviderId(id, pagination);
        return ResponseEntity.ok(serviceProviderExperiences.map(ServiceProviderExperienceDataList::new));
    }

    @Transactional
    @Override
    public ResponseEntity<ServiceProviderExperienceDataResponse> createdServiceProviderExperience
            (ServiceProviderExperienceDataCreate dataCreate, UriComponentsBuilder uriComponentsBuilder,
             MultipartFile imageFile) throws IOException {
        if (serviceProviderRepository.findById(dataCreate.idServiceProvider()).isEmpty()) {
            throw new IntegrityValidation("This provider ID does not was found");
        }
        ServiceProvider serviceProvider = serviceProviderRepository.findById(dataCreate.idServiceProvider()).get();
        Map imageCreated = null;
        if (imageFile != null) {
            if (MethodsUtil.isFileImageFormat(imageFile)) {
                imageCreated = new HashMap(uploadImage(imageFile, "servilink/service-provider-experience/"));
            } else {
                throw new IntegrityValidation("Only accept image files!");
            }
        }
        ServiceProviderExperience saveServiceProviderExperience = new ServiceProviderExperience(
                imageCreated.get("secure_url").toString(), imageCreated.get("public_id").toString(),
                dataCreate.altText(), dataCreate.experienceDescription(), serviceProvider);
        serviceProviderExperienceRepository.save(saveServiceProviderExperience);
        URI url = uriComponentsBuilder.path("/service-provider-experience/{id}")
                .buildAndExpand(saveServiceProviderExperience.getId()).toUri();
        return ResponseEntity.created(url).body(generateServiceProviderExperienceDataResponse(saveServiceProviderExperience));
    }

    @Transactional
    @Override
    public ResponseEntity<ServiceProviderExperienceDataResponse> updateServiceProviderExperience
            (Long id, ServiceProviderExperienceDataUpdate dataUpdate, MultipartFile imageFile) throws IOException {
        MethodsUtil.existsById(id, serviceProviderExperienceRepository, "Service Provider Experience");
        ServiceProviderExperience serviceProviderExperience = serviceProviderExperienceRepository.getReferenceById(id);
        if(imageFile != null) {
            if (MethodsUtil.isFileImageFormat(imageFile)){
                if(serviceProviderExperience.getImageUrl() != null){
                    cloudinary.uploader().destroy(serviceProviderExperience.getCloudinaryPublicId(), Map.of());
                }
                Map imageUploaded = new HashMap(uploadImage(imageFile, "servilink/service-provider-experience/"));
                serviceProviderExperience.setImageUrl(imageUploaded.get("secure_url").toString());
                serviceProviderExperience.setCloudinaryPublicId(imageUploaded.get("public_id").toString());
            } else {
                throw new IntegrityValidation("Only accept image files!");
            }
        }
        serviceProviderExperience.updateData(dataUpdate);
        return ResponseEntity.ok(generateServiceProviderExperienceDataResponse(serviceProviderExperience));
    }

    @Transactional
    @Override
    public ResponseEntity deleteServiceProviderExperience(Long id) throws IOException {
        MethodsUtil.existsById(id, serviceProviderExperienceRepository, "Service Provider Experience");
        ServiceProviderExperience serviceProviderExperience = serviceProviderExperienceRepository.getReferenceById(id);
        if(serviceProviderExperience.getImageUrl() != null){
            cloudinary.uploader().destroy(serviceProviderExperience.getCloudinaryPublicId(), Map.of());
        }
        serviceProviderExperienceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
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

    @Override
    public Map uploadImage(MultipartFile imageFile, String path) {
        try {
            return this.cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.asMap(
                    "folder", path));
        } catch (IOException e) {
            throw new RuntimeException("Image uploading failed!");
        }
    }


}
