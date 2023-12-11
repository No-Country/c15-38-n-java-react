package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.model.dto.ServiceCategoryDataResponse;
import com.c1538njavareact.serviLink.repository.IServiceCategoryRepository;
import com.c1538njavareact.serviLink.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceCategory implements IServiceCategory {

    @Autowired
    private IServiceCategoryRepository categoryRepository;


    @Override
    public List<ServiceCategoryDataResponse> getAllServiceCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(serviceCategory -> ServiceCategoryDataResponse.builder()
                        .category(serviceCategory.getName())
                        .build())
                .toList();
    }
}
