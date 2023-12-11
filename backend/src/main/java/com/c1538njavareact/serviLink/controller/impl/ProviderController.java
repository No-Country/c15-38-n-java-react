package com.c1538njavareact.serviLink.controller.impl;

import com.c1538njavareact.serviLink.controller.IProviderController;
import com.c1538njavareact.serviLink.model.dto.ProviderDataGetOne;
import com.c1538njavareact.serviLink.model.dto.ProviderDataUpdate;
import com.c1538njavareact.serviLink.service.IProviderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.c1538njavareact.serviLink.config.ApiConstants.PROVIDER_URI;

@RestController
@RequestMapping(PROVIDER_URI)
public class ProviderController implements IProviderController {
    @Autowired
    IProviderService providerService;

    @Override
    public ResponseEntity<ProviderDataGetOne> getOne(Long id) {
        return providerService.getByUserId(id);
    }

    @Override
    @Transactional
    public ResponseEntity<ProviderDataGetOne> updateProvider(Long id, ProviderDataUpdate providerDataUpdate) {
        return providerService.updateProvider(id, providerDataUpdate);
    }

    @Override
    @Transactional
    public ResponseEntity deactivateProvider(Long id) {
        return providerService.deactivateProvider(id);
    }

}
