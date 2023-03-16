package com.developpment_group.service_apres_vente.module.Services.SAVService;


import com.developpment_group.service_apres_vente.module.Modules.SAV.RequestApproval;
import com.developpment_group.service_apres_vente.module.Modules.SAV.status;
import com.developpment_group.service_apres_vente.module.Repositories.RequestApprovalRepo;
import com.developpment_group.service_apres_vente.module.Services.IServices.IRequestApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestApprovalService implements IRequestApprovalService {

    @Autowired
    private RequestApprovalRepo Reques_Approval_Repo;


    @Override
    public RequestApproval createShipping(RequestApproval approval) {
        return Reques_Approval_Repo.save(approval);
    }

    @Override
    public List<RequestApproval> getApproval() {
        List<RequestApproval> AllAPPROVALS;
        return AllAPPROVALS = Reques_Approval_Repo.findAll();
    }

    @Override
    public void clearShipping(Long approvalID) {
        Reques_Approval_Repo.deleteById(approvalID);

    }


}
