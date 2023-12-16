package com.c1538njavareact.serviLink.controller;


import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataCreate;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataList;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataResponse;
import com.c1538njavareact.serviLink.model.dto.ServiceProviderExperienceDataUpdate;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Validated
public interface IServiceProviderExperienceController {

    @GetMapping(path = "/{id}")
    ResponseEntity<ServiceProviderExperienceDataResponse> getById(@PathVariable Long id);

    @GetMapping(path = "/get-all-by-service-provider/{id}")
    ResponseEntity<Page<ServiceProviderExperienceDataList>> getByIdServiceProvider
            (@PathVariable Long id, @PageableDefault(size = 10) Pageable pagination);

    @PostMapping()
    ResponseEntity<ServiceProviderExperienceDataResponse> createdServiceProviderExperience
            (@Valid ServiceProviderExperienceDataCreate serviceProviderExperienceData, UriComponentsBuilder uriComponentsBuilder,
             @RequestParam("imageFile")MultipartFile imageFile) throws IOException;

    @PutMapping(path = "/{id}")
    ResponseEntity<ServiceProviderExperienceDataResponse> updateServiceProviderExperience
            (@PathVariable Long id, @Valid ServiceProviderExperienceDataUpdate dataUpdate,
             @RequestParam("imageFile")MultipartFile imageFile) throws IOException;
}
