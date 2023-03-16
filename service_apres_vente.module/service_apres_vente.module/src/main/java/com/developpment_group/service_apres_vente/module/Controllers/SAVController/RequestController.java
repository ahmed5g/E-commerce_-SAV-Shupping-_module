package com.developpment_group.service_apres_vente.module.Controllers.SAVController;

import com.developpment_group.service_apres_vente.module.Common.ApiResponse;
import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Services.SAVService.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/Request")
public class RequestController {

    @Autowired
    private RequestService Request_Service;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createRequest(@Validated @RequestBody Request request) {
        if (Objects.nonNull(Request_Service.readRequest(request.getOrder()))) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Request already exists"), HttpStatus.CONFLICT);
        }
        Request_Service.createRequest(request);
        return new ResponseEntity<>(new ApiResponse(true, "Request has been successfully Added"), HttpStatus.CREATED);
    }

    @GetMapping("/ALL")
    public List<Request> retriveAllRequests(){
        return Request_Service.GetallRequests();
    }

    @GetMapping("/{Request-ID}")
    public void retiriveRequestByID(@PathVariable("Request-ID") Long Request_ID){Request_Service.GetRequestByID(Request_ID);    }

    @PutMapping("/update")
    public Request updateRequest(@RequestBody Request request){
        return Request_Service.updateRequest(request);
    }

    @DeleteMapping("/delete/{requestID}")
    public void deleteRequest(@PathVariable("requestID") Long orderId){
        Request_Service.clearRequest(orderId);
    }


    // Read Request by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Request>> readRequestByStatus(@PathVariable("status") boolean status) {
        try {
            List<Request> requests = Request_Service.GetAllRequestsByStatus(status);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
