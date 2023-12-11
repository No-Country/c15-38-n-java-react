package com.c1538njavareact.serviLink.controller.impl;

import com.c1538njavareact.serviLink.controller.IServiceController;
import com.c1538njavareact.serviLink.model.dto.ServiceDataResponse;
import com.c1538njavareact.serviLink.service.ISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static com.c1538njavareact.serviLink.config.ApiConstants.SERVICE_URI;

@RestController
@RequestMapping(SERVICE_URI)
@CrossOrigin(origins = "*")
public class ServiceController implements IServiceController {

    @Autowired
    private ISService service;

    @Override
    public ResponseEntity<List<ServiceDataResponse>> getListAllServices() {
        List<ServiceDataResponse> listAllServices = service.getAllServices();
        return ResponseEntity.ok(listAllServices);
    }
}
