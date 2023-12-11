package com.c1538njavareact.serviLink.repository;

import com.c1538njavareact.serviLink.model.entity.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {
}
