package com.c1538njavareact.serviLink.service;

import com.c1538njavareact.serviLink.model.dto.ProviderDataGetOne;
import com.c1538njavareact.serviLink.model.dto.ProviderDataUpdate;
import org.springframework.http.ResponseEntity;

public interface IProviderService {
    public ResponseEntity<ProviderDataGetOne> getByUserId(Long id);

    public ResponseEntity<ProviderDataGetOne> updateProvider(Long id, ProviderDataUpdate providerDataUpdate);
    public ResponseEntity deactivateProvider(Long id);
}
