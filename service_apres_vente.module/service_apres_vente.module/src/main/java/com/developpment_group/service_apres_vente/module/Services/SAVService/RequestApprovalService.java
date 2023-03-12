package com.developpment_group.service_apres_vente.module.Services.SAVService;


import com.developpment_group.service_apres_vente.module.Repositories.RequestApprovalRepo;
import com.developpment_group.service_apres_vente.module.Services.IServices.IRequestApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestApprovalService implements IRequestApprovalService {

    @Autowired
    private RequestApprovalRepo Reques_Approval_Repo;



}
