package com.c1538njavareact.serviLink.controller;

import com.c1538njavareact.serviLink.model.dto.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Validated
public interface IServiceProviderController {
    @GetMapping("/{id}")
    ResponseEntity<ServiceProviderData> createServiceProvider(@PathVariable Long id);
    @GetMapping("/get-all-by-provider/{id}")
    ResponseEntity<Page<ServiceProviderDataList>> getByIdProvider(@PathVariable Long id, @PageableDefault(size = 10) Pageable pagination);
    @GetMapping("/get-all-by-service/{id}")
    ResponseEntity<Page<ServiceProviderDataList>> getByIdService(@PathVariable Long id, @PageableDefault(size = 10) Pageable pagination);
    @PostMapping
    ResponseEntity<ServiceProviderData> createServiceProvider(@RequestBody @Valid ServiceProviderDataCreate serviceProviderDataCreate, UriComponentsBuilder uriComponentsBuilder);
    @PutMapping("/{id}")
    ResponseEntity<ServiceProviderData> updateServiceProvider(@PathVariable Long id, @RequestBody @Valid ServiceProviderDataUpdate serviceProviderDataUpdate);
    @DeleteMapping("/{id}")
    ResponseEntity deleteServiceProvider(@PathVariable Long id);
}
