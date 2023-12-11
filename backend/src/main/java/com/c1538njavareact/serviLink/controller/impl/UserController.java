package com.c1538njavareact.serviLink.controller.impl;

import com.c1538njavareact.serviLink.model.dto.JwtTokenData;
import com.c1538njavareact.serviLink.model.dto.UserDataLogin;
import com.c1538njavareact.serviLink.model.dto.UserDataSignUp;
import com.c1538njavareact.serviLink.service.impl.UserService;
import com.c1538njavareact.serviLink.utils.JWTUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/auth")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtService;

    @PostMapping("/login")
    public ResponseEntity authenticateUser(@RequestBody @Valid UserDataLogin userDataLogin) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDataLogin.username(),
                userDataLogin.password()));
        String jwtToken = jwtService.generateToken(userDataLogin.username());
        return ResponseEntity.ok(new JwtTokenData(jwtToken));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDataLogin> createProvider(@RequestBody @Valid UserDataSignUp providerDataSave, UriComponentsBuilder uriComponentsBuilder) {
        return userService.createUser(providerDataSave, uriComponentsBuilder);
    }
}
