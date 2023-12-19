package com.c1538njavareact.serviLink.service;

import com.c1538njavareact.serviLink.model.dto.ServiceDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISService {

    ResponseEntity<List<ServiceDataResponse>> getAllServices();

}
