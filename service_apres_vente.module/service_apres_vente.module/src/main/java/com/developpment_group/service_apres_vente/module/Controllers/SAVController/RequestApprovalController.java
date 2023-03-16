package com.developpment_group.service_apres_vente.module.Controllers.SAVController;



import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Modules.SAV.RequestApproval;
import com.developpment_group.service_apres_vente.module.Modules.SAV.status;
import com.developpment_group.service_apres_vente.module.Repositories.RequestApprovalRepo;
import com.developpment_group.service_apres_vente.module.Repositories.RequestRepo;
import com.developpment_group.service_apres_vente.module.Services.SAVService.RequestApprovalService;
import com.developpment_group.service_apres_vente.module.Services.SAVService.RequestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/RequestApproval")
public class RequestApprovalController {

    @Autowired
    private RequestApprovalService Request_Approval_Service;


    @Autowired
    private RequestApprovalRepo RequestApprovalRepo;

    @Autowired
    private RequestRepo RequestRepo;



    @PostMapping("/set-Request")
    public RequestApproval createApproval(@RequestBody RequestApproval approval){
        return Request_Approval_Service.createShipping(approval);
    }


    @GetMapping("/get")
    public List<RequestApproval> retriveApprovals(){
        return Request_Approval_Service.getApproval();
    }



    @DeleteMapping("/delete/{approval}")
    public void deleteApproval(@PathVariable("approval") Long approvalID){
        Request_Approval_Service.clearShipping(approvalID);
    }

    @PutMapping("Request/{approvalId}")
    public ResponseEntity<String> approveRequest(@PathVariable Long approvalId, @RequestBody RequestApproval requestApproval) {
        Optional<RequestApproval> optionalRequestApproval = RequestApprovalRepo.findById(approvalId);

        if (optionalRequestApproval.isPresent()) {
            RequestApproval existingRequestApproval = optionalRequestApproval.get();
            existingRequestApproval.setRequestStatus(requestApproval.getRequestStatus());

            Request request = existingRequestApproval.getRequests();
            boolean isApproved = request.setApprovalStatus(requestApproval.getRequestStatus());

            RequestApprovalRepo.save(existingRequestApproval);
            RequestRepo.save(request);

            return ResponseEntity.ok("Request approval updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
