package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.exception.IntegrityValidation;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderData;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderDataCreate;
import com.c1538njavareact.serviLink.model.entity.Provider;
import com.c1538njavareact.serviLink.model.entity.ServiceCategory;
import com.c1538njavareact.serviLink.model.entity.ServiceProvider;
import com.c1538njavareact.serviLink.repository.ProviderRepository;
import com.c1538njavareact.serviLink.repository.ServiceProviderRepository;
import com.c1538njavareact.serviLink.service.IServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ServiceProviderService implements IServiceProviderService {

    @Autowired
    private ProviderRepository providerRepository;
//    @Autowired
//    private ServiceRepository serviceRepository;
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Override
    public ResponseEntity<ServiceProvider> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ServiceProviderData> createServiceProvider(ServiceProviderDataCreate serviceProviderDataCreate, UriComponentsBuilder uriComponentsBuilder) {
        if(providerRepository.findById(serviceProviderDataCreate.idProvider()).isEmpty()){
            throw new IntegrityValidation("This provider ID does not was found");
        }

//        if(serviceRepository.findById(serviceProviderDataCreate.idService()).isEmpty()){
//            throw new IntegrityValidation("This service ID does not was found");
//        }

        Provider provider = providerRepository.findById(serviceProviderDataCreate.idProvider()).get();
        //Service service = serviceRepository.findById(serviceProviderDataCreate.idService()).get();
        com.c1538njavareact.serviLink.model.entity.Service service = new com.c1538njavareact.serviLink.model.entity.Service(1L, "Fontanería", new ServiceCategory(1L, "Servicios del Hogar" ));


        ServiceProvider serviceProvider = new ServiceProvider(provider,service,serviceProviderDataCreate.description(),
                serviceProviderDataCreate.price());

        serviceProviderRepository.save(serviceProvider);

        ServiceProviderData serviceProviderData = new ServiceProviderData(serviceProvider.getId(),
                new Provider(serviceProvider.getProvider().getFirstName(),
                        serviceProvider.getProvider().getEmail(), serviceProvider.getProvider().getUser()
                        ),
                new com.c1538njavareact.serviLink.model.entity.Service(serviceProvider.getService().getId(),
                        serviceProvider.getService().getName(), serviceProvider.getService().getServiceCategory()
                        ),
                serviceProvider.getDescription(), serviceProvider.getPrice()
                );

        URI url = uriComponentsBuilder.path("/serviceprovider/{id}").buildAndExpand(serviceProvider.getId()).toUri();

        return ResponseEntity.created(url).body(serviceProviderData);
    }
}
