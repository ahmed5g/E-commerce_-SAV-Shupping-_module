package com.developpment_group.service_apres_vente.module.Services.SAVService;


import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Repositories.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepo Request_repo;


    public Request readRequest(String order_ID) {
        return Request_repo.findByOrder(order_ID);
    }


    public Request createRequest(Request request){
        return Request_repo.save(request);
    }
}
