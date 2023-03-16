package com.developpment_group.service_apres_vente.module.Services.IServices;


import com.developpment_group.service_apres_vente.module.Modules.SAV.RequestApproval;

import java.util.List;

public interface IRequestApprovalService {
    RequestApproval createShipping(RequestApproval approval);

    List<RequestApproval> getApproval();

    void clearShipping(Long approvalID);

}
