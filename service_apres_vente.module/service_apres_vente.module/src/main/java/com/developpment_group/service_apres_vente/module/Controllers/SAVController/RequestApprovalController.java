package com.developpment_group.service_apres_vente.module.Controllers.SAVController;


import com.developpment_group.service_apres_vente.module.Services.SAVService.RequestApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RequestApproval")
public class RequestApprovalController {

    @Autowired
    private RequestApprovalService Request_Approval_Service;
}
