package com.developpment_group.service_apres_vente.module.Services.IServices;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;

import java.util.List;
import java.util.Optional;

public interface IRequestService {
    Request createRequest(Request request);

    Request updateRequest(Request request) ;

    List<Request> GetallRequests();
    void GetRequestByID(Long requestID);
    void clearRequest(Long requestID);
}
