package com.developpment_group.service_apres_vente.module.Repositories;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Modules.SAV.RequestApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestApprovalRepo extends JpaRepository<RequestApproval, Long> {

    Optional<RequestApproval> findById(Long approvalId);
    void deleteById(Long id);

}
