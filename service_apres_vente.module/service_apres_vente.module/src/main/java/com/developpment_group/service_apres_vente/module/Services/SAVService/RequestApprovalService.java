package com.developpment_group.service_apres_vente.module.Services.SAVService;


import com.developpment_group.service_apres_vente.module.Modules.SAV.RequestApproval;
import com.developpment_group.service_apres_vente.module.Repositories.RequestApprovalRepo;
import com.developpment_group.service_apres_vente.module.Services.IServices.IRequestApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestApprovalService implements IRequestApprovalService {

    @Autowired
    private RequestApprovalRepo Reques_Approval_Repo;



    @Override
    public RequestApproval createRequestApproval(RequestApproval request) {
        return Reques_Approval_Repo.save(request);
    }

    @Override
    public RequestApproval updateRequestApproval(RequestApproval request) {
        return null;
    }

    @Override
    public List<RequestApproval> GetallRequestsApprovals() {
        return Reques_Approval_Repo.findAll();
    }

    public RequestApproval getRequestApprovalByID(Long ID){
        Optional<RequestApproval> RQA = this.Reques_Approval_Repo.findById(ID);
        return RQA.orElse(new RequestApproval());
    }

    @Override
    public void clearRequestApproval(Long approvalId) {
        Reques_Approval_Repo.deleteById(approvalId);

    }



}
