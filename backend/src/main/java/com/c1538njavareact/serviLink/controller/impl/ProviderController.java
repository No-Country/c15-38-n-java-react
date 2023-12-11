package com.c1538njavareact.serviLink.controller.impl;

import com.c1538njavareact.serviLink.controller.IProviderController;
import com.c1538njavareact.serviLink.model.dto.ProviderDataGetOne;
import com.c1538njavareact.serviLink.model.dto.ProviderDataUpdate;
import com.c1538njavareact.serviLink.model.dto.UserDataLogin;
import com.c1538njavareact.serviLink.service.IProviderService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/provider")
public class ProviderController {
    @Autowired
    IProviderService providerService;

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDataGetOne> getOne(@PathVariable Long id) {
        return providerService.getByUserId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProviderDataGetOne> updateProvider(@PathVariable Long id, @Valid ProviderDataUpdate providerDataUpdate) {
        return providerService.updateProvider(id, providerDataUpdate);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deactivateProvider(@PathVariable Long id) {
        return providerService.deactivateProvider(id);
    }

}
