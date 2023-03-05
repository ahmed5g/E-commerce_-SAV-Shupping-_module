package com.developpment_group.service_apres_vente.module.Repositories;

import com.developpment_group.service_apres_vente.module.Modules.SAV.RefundRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RefundRequestRepo extends JpaRepository<RefundRequest,Long> {
}
