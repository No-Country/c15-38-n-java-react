package com.c1538njavareact.serviLink.controller;

import com.c1538njavareact.serviLink.model.dto.ServiceCategoryDataResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

public interface IServiceCategoryController {

    @GetMapping(path = "/get-all-categories", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ServiceCategoryDataResponse>> getAllCategories();

}
