package com.developpment_group.service_apres_vente.module.Controllers.SAVController;


import com.developpment_group.service_apres_vente.module.Common.ApiResponse;
import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Services.SAVService.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/Request")
public class RequestController {


    @Autowired
    private RequestService Request_Service;


    @PostMapping("/Create")
    public ResponseEntity<ApiResponse> createCategory(@Validated @RequestBody Request request) {
        if (Objects.nonNull(Request_Service.readRequest(request.getOrder()))) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Request already exists"), HttpStatus.CONFLICT);
        }
        Request_Service.createRequest(request);
        return new ResponseEntity<>(new ApiResponse(true, "Request has been successfully Added"), HttpStatus.CREATED);
    }
}
