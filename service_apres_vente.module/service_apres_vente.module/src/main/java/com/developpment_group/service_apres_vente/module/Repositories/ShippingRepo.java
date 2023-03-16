package com.developpment_group.service_apres_vente.module.Repositories;

import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShippingRepo extends JpaRepository<Shipping, Long> {

    List<Shipping> findByRequests_RequestID(Shipping requestId);


    Optional<Shipping> findById(Long id);
    void deleteById(Long id);
}
