package com.developpment_group.service_apres_vente.module.Services.IServices;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;

import java.util.List;
import java.util.Optional;

public interface IRequestService {

    Request findByOrder(String order);

    Optional<Request> findById(Long requestID);



    void deleteById(Long id);

    void clearRequest(Long requestID);

    Request createRequest(Request request);

    Request updateRequest(Request request) ;
    List<Request> GetallRequests();
    void GetRequestByID(Long requestID);
}
