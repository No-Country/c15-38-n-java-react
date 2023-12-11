package com.c1538njavareact.serviLink.service;

import com.c1538njavareact.serviLink.model.dto.ServiceCategoryDataResponse;
import java.util.List;

public interface IServiceCategory {

    List<ServiceCategoryDataResponse> getAllServiceCategories();

}
