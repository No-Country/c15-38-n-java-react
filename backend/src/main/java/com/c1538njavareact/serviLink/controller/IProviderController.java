package com.c1538njavareact.serviLink.controller;

import com.c1538njavareact.serviLink.model.dto.ProviderDataGetOne;
import com.c1538njavareact.serviLink.model.dto.ProviderDataUpdate;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Validated
public interface IProviderController {
    @GetMapping("/{id}")
    ResponseEntity<ProviderDataGetOne> getOne(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<ProviderDataGetOne> updateProvider(@PathVariable Long id, @Valid ProviderDataUpdate providerDataUpdate);

    @DeleteMapping("/{id}")
    ResponseEntity deactivateProvider(@PathVariable Long id);


}