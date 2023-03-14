package com.developpment_group.service_apres_vente.module.Services.SAVService;


import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Repositories.RequestRepo;
import com.developpment_group.service_apres_vente.module.Services.IServices.IRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class RequestService implements IRequestService {

    @Autowired
    private RequestRepo Request_repo;



    //Methods
    public Request readRequest(String order_ID) {return Request_repo.findByOrder(order_ID);}

    //Operations



    public Request createRequest(Request request){
        return Request_repo.save(request);
    }



    public Request updateRequest(Request request) {
        try {
            Long id = request.getRequestID();
            Optional<Request> existingRequest = Request_repo.findById(id);
            if (existingRequest.isPresent()) {
                Request updatedRequest = existingRequest.get();
                updatedRequest.setCustomerName(request.getCustomerName());
                updatedRequest.setCustomerAdress(request.getCustomerAdress());
                updatedRequest.setCustomerEmail(request.getCustomerEmail());
                updatedRequest.setRequestDate(request.getRequestDate());
                updatedRequest.setIsApproved(request.getIsApproved());
                updatedRequest.setOrder(request.getOrder());
                updatedRequest.setDescription(request.getDescription());
                updatedRequest.setRequestID(request.getRequestID());
                return Request_repo.save(updatedRequest);
            } else {
                throw new RuntimeException("Request with ID " + id + " not found");
            }
        } catch (Exception e) {
            // Handle any exceptions thrown during the update process
            e.printStackTrace();
            throw new RuntimeException("Failed to update Request: " + e.getMessage());
        }
    }


    public List<Request> GetallRequests() {
        return Request_repo.findAll();
    }

    public void GetRequestByID(Long requestID){
        Request_repo.findById(requestID);
    }

    public void clearRequest(Long requestID) {
        Request_repo.deleteById(requestID);

    }
}
