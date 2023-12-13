package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.model.dto.ProviderDataGetOne;
import com.c1538njavareact.serviLink.model.dto.ProviderDataUpdate;
import com.c1538njavareact.serviLink.model.entity.Provider;
import com.c1538njavareact.serviLink.repository.IProviderRepository;
import com.c1538njavareact.serviLink.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProviderService implements IProviderService {
    @Autowired
    private IProviderRepository IProviderRepository;

    @Override
    public ResponseEntity<ProviderDataGetOne> getByUserId(Long id) {
        Provider provider = IProviderRepository.findByUserId(id);
        ProviderDataGetOne providerDataGetOne = new ProviderDataGetOne(provider.getFirstName(), provider.getLastName(),
                provider.getEmail(), provider.getPhoneNumber(), provider.getProfileImageUrl());
        return ResponseEntity.ok(providerDataGetOne);
    }

    @Override
    public ResponseEntity<ProviderDataGetOne> updateProvider(Long id, ProviderDataUpdate providerDataUpdate) {
        Provider provider = IProviderRepository.getReferenceByUserId(id);
        provider.updateData(providerDataUpdate);
        return ResponseEntity.ok(new ProviderDataGetOne(provider.getFirstName(), provider.getLastName(),
                provider.getEmail(), provider.getPhoneNumber(), provider.getProfileImageUrl()));
    }

    @Override
    public ResponseEntity deactivateProvider(Long id) {
        Provider provider = IProviderRepository.getReferenceByUserId(id);
        provider.deactivateProvider();
        return ResponseEntity.noContent().build();
    }

}
