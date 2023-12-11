package com.c1538njavareact.serviLink.controller;

import com.c1538njavareact.serviLink.model.dto.ProviderDataGetOne;
import com.c1538njavareact.serviLink.model.dto.ProviderDataUpdate;
import com.c1538njavareact.serviLink.model.dto.UserDataLogin;
import com.c1538njavareact.serviLink.model.dto.UserDataSignUp;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

@Validated
public interface IProviderController {
    public ResponseEntity<ProviderDataGetOne> getOne(Long id);

    public ResponseEntity<ProviderDataGetOne> updateProvider(Long id, ProviderDataUpdate providerDataUpdate);

}