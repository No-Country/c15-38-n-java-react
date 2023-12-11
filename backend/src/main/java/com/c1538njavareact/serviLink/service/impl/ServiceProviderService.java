package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.exception.IntegrityValidation;
import com.c1538njavareact.serviLink.model.dto.ProviderDataGetOne;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderData;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderDataCreate;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderDataList;
import com.c1538njavareact.serviLink.model.entity.Provider;
import com.c1538njavareact.serviLink.model.entity.ServiceProvider;
import com.c1538njavareact.serviLink.repository.IProviderRepository;
import com.c1538njavareact.serviLink.repository.IServiceProviderRepository;
import com.c1538njavareact.serviLink.repository.IServiceRepository;
import com.c1538njavareact.serviLink.service.IServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ServiceProviderService implements IServiceProviderService {

    @Autowired
    private IProviderRepository IProviderRepository;
    @Autowired
    private IServiceRepository IServiceRepository;
    @Autowired
    private IServiceProviderRepository IServiceProviderRepository;


    @Override
    public ResponseEntity<ServiceProviderData> getById(Long id) {
        ServiceProvider serviceProvider = IServiceProviderRepository.findById(id).get();
        return ResponseEntity.ok(generateServiceProviderData(serviceProvider));
    }

    @Override
    public ResponseEntity<Page<ServiceProviderDataList>> getByIdProvider(Long id, Pageable pagination) {
        Page<ServiceProvider> serviceProvider = IServiceProviderRepository.findByProviderId(id, pagination);
        return ResponseEntity.ok(serviceProvider.map(ServiceProviderDataList::new));
    }

    @Override
    public ResponseEntity<Page<ServiceProviderDataList>> getByIdService(Long id, Pageable pagination) {
        Page<ServiceProvider> serviceProvider = IServiceProviderRepository.findByServiceId(id, pagination);
        return ResponseEntity.ok(serviceProvider.map(ServiceProviderDataList::new));
    }

    @Override
    public ResponseEntity<ServiceProviderData> createServiceProvider(ServiceProviderDataCreate serviceProviderDataCreate, UriComponentsBuilder uriComponentsBuilder) {
        if(IProviderRepository.findById(serviceProviderDataCreate.idProvider()).isEmpty()){
            throw new IntegrityValidation("This provider ID does not was found");
        }

        if(IServiceRepository.findById(serviceProviderDataCreate.idService()).isEmpty()){
            throw new IntegrityValidation("This service ID does not was found");
        }

        Provider provider = IProviderRepository.findById(serviceProviderDataCreate.idProvider()).get();
        com.c1538njavareact.serviLink.model.entity.Service service = IServiceRepository.findById(serviceProviderDataCreate.idService()).get();

        ServiceProvider serviceProvider = new ServiceProvider(provider,service,serviceProviderDataCreate.description(),
                serviceProviderDataCreate.price());

        IServiceProviderRepository.save(serviceProvider);

        URI url = uriComponentsBuilder.path("/serviceprovider/{id}").buildAndExpand(serviceProvider.getId()).toUri();

        return ResponseEntity.created(url).body(generateServiceProviderData(serviceProvider));
    }

    private ServiceProviderData generateServiceProviderData(ServiceProvider serviceProvider){
        return new ServiceProviderData(serviceProvider.getId(),
                new ProviderDataGetOne(serviceProvider.getProvider().getFirstName(),
                        serviceProvider.getProvider().getLastName(), serviceProvider.getProvider().getEmail(),
                        serviceProvider.getProvider().getPhoneNumber(), serviceProvider.getProvider().getProfileImageUrl()
                ),
                new com.c1538njavareact.serviLink.model.entity.Service(serviceProvider.getService().getId(),
                        serviceProvider.getService().getName(), serviceProvider.getService().getServiceCategory()
                ),
                serviceProvider.getDescription(), serviceProvider.getPrice()
        );
    }

}
