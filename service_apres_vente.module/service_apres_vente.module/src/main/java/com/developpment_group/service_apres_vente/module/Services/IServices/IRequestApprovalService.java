package com.developpment_group.service_apres_vente.module.Services.IServices;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Modules.SAV.RequestApproval;

import java.util.List;

public interface IRequestApprovalService {
    RequestApproval createRequestApproval(RequestApproval request);

    RequestApproval updateRequestApproval(RequestApproval request) ;

    List<RequestApproval> GetallRequestsApprovals();
    RequestApproval getRequestApprovalByID(Long ID);
    void clearRequestApproval(Long approvalId);
}
