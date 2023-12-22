package com.c1538njavareact.serviLink.controller;

import com.c1538njavareact.serviLink.model.dto.JwtTokenData;
import com.c1538njavareact.serviLink.model.dto.UserDataLogin;
import com.c1538njavareact.serviLink.model.dto.UserDataSignUp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

public interface IUserController {
    @PostMapping("/login")
    ResponseEntity<JwtTokenData> authenticateUser(@RequestBody @Valid UserDataLogin userDataLogin);

    @PostMapping("/signup")
    ResponseEntity<UserDataLogin> createProvider(@RequestBody @Valid UserDataSignUp providerDataSave, UriComponentsBuilder uriComponentsBuilder);
}
