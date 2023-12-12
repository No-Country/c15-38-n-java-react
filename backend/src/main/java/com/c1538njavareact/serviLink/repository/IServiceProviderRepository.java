package com.c1538njavareact.serviLink.repository;

import com.c1538njavareact.serviLink.model.entity.ServiceProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
    Page<ServiceProvider> findByProviderId(Long id, Pageable pagination);
    Page<ServiceProvider> findByServiceId(Long id, Pageable pagination);
}
