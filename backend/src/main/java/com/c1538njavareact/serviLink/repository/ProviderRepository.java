package com.c1538njavareact.serviLink.repository;

import com.c1538njavareact.serviLink.model.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    UserDetails findByEmail(String email);
}
