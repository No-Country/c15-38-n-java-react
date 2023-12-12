package com.c1538njavareact.serviLink.service;

import com.c1538njavareact.serviLink.model.dto.UserDataLogin;
import com.c1538njavareact.serviLink.model.dto.UserDataSignUp;
import com.c1538njavareact.serviLink.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface IUserService {
    ResponseEntity<UserDataLogin> createUser(UserDataSignUp userDataSignUp, UriComponentsBuilder uriComponentsBuilder);

    User findByUsername(String username);

    User findByEmail(String email);

    User updatePasswordByEmail(String email, String password);
}
