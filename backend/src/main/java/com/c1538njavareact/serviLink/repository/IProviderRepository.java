package com.c1538njavareact.serviLink.repository;

import com.c1538njavareact.serviLink.model.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProviderRepository extends JpaRepository<Provider, Long> {

    Provider findByUserId(Long id);
    Provider getReferenceByUserId(Long id);
}
