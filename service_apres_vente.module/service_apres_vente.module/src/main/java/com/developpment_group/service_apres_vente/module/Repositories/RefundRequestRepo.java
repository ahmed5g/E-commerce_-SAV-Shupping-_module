package com.developpment_group.service_apres_vente.module.Repositories;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RefundRequestRepo extends JpaRepository<Request,Long> {
}
