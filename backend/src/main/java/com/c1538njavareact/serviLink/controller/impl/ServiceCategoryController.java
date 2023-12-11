package com.c1538njavareact.serviLink.controller.impl;

import com.c1538njavareact.serviLink.controller.IServiceCategoryController;
import com.c1538njavareact.serviLink.model.dto.ServiceCategoryDataResponse;
import com.c1538njavareact.serviLink.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static com.c1538njavareact.serviLink.config.ApiConstants.SERVICE_CATEGORY_URI;

@RestController
@RequestMapping(SERVICE_CATEGORY_URI)
@CrossOrigin(origins = "*")
public class ServiceCategoryController implements IServiceCategoryController {

    @Autowired
    private IServiceCategory serviceCategory;

    @Override
    public ResponseEntity<List<ServiceCategoryDataResponse>> getAllCategories() {
        List<ServiceCategoryDataResponse> listAllServiceCategories = serviceCategory.getAllServiceCategories();
        return ResponseEntity.ok(listAllServiceCategories);
    }

}
