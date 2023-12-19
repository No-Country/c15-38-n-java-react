package com.c1538njavareact.serviLink.repository;

import com.c1538njavareact.serviLink.model.entity.ServiceProviderExperience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceProviderExperienceRepository extends JpaRepository<ServiceProviderExperience, Long> {

    Page<ServiceProviderExperience> findByServicesProviderId(Long id, Pageable pagination);

}
