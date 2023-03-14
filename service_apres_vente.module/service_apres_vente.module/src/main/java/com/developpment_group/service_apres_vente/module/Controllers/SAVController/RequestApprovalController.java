package com.developpment_group.service_apres_vente.module.Controllers.SAVController;


import com.developpment_group.service_apres_vente.module.Common.ApiResponse;
import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Modules.SAV.RequestApproval;
import com.developpment_group.service_apres_vente.module.Services.SAVService.RequestApprovalService;
import com.developpment_group.service_apres_vente.module.Services.SAVService.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/RequestApproval")
public class RequestApprovalController {

    @Autowired
    private RequestApprovalService Request_Approval_Service;



    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createRequest(@Validated @RequestBody RequestApproval request) {
        RequestApproval requestApproval = Request_Approval_Service.getRequestApprovalByID(request.getApprovalId());
        if (requestApproval != null){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "RequestApproval already exists"), HttpStatus.CONFLICT);
        }
        Request_Approval_Service.createRequestApproval(request);
        return new ResponseEntity<>(new ApiResponse(true, "Request has been successfully Approved"), HttpStatus.CREATED);
    }

    @GetMapping("/ALL")
    public List<RequestApproval> retriveAllRequests(){
        return Request_Approval_Service.GetallRequestsApprovals();
    }

    @GetMapping("/{Request-ID}")
    public void retiriveRequestByID(@PathVariable("Request-ID") Long Request_ID){Request_Approval_Service.getRequestApprovalByID(Request_ID);    }

    @PutMapping("/update")
    public RequestApproval updateRequest(@RequestBody RequestApproval request){
        return Request_Approval_Service.updateRequestApproval(request);
    }

    @DeleteMapping("/delete/{approvalID}")
    public void deleteRequest(@PathVariable("requestID") Long approvalID){
        Request_Approval_Service.clearRequestApproval(approvalID);
    }
}
