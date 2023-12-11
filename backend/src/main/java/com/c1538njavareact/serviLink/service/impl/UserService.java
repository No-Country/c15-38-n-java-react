package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.exception.AuthValidation;
import com.c1538njavareact.serviLink.exception.IntegrityValidation;
import com.c1538njavareact.serviLink.model.dto.UserDataLogin;
import com.c1538njavareact.serviLink.model.dto.UserDataSignUp;
import com.c1538njavareact.serviLink.model.entity.Provider;
import com.c1538njavareact.serviLink.model.entity.User;
import com.c1538njavareact.serviLink.repository.UserRepository;
import com.c1538njavareact.serviLink.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class UserService implements UserDetailsService, IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByUsername(username);
        if(user.isEnabled()){
            return userRepository.findByUsername(username);
        } else {
            throw new AuthValidation(
                    "This user is not active");
        }

    }

    @Override
    public ResponseEntity<UserDataLogin> createUser(UserDataSignUp userDataSignUp, UriComponentsBuilder uriComponentsBuilder) {
        if (userRepository.existsByUsername(userDataSignUp.email())) {
            throw new IntegrityValidation(
                    "This email already exists");
        }

        User user =  userRepository.saveAndFlush(new User(userDataSignUp, passwordEncoder.encode(userDataSignUp.password())));
        UserDataLogin providerDataLogin = new UserDataLogin(user.getId(), user.getUsername(), user.getPassword());

        Provider provider = new Provider(userDataSignUp.firstName(), userDataSignUp.email(), user);
        user.setProvider(provider);

        userRepository.saveAndFlush(user);

        URI url = uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(url).body(providerDataLogin);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User updatePasswordByEmail(String email, String password) {
        return null;
    }
}
