package com.developpment_group.service_apres_vente.module.Repositories;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShippingRepo extends JpaRepository<Shipping, Long> {
    @Query("SELECT s FROM Shipping s "
            + "INNER JOIN s.requests_ship r "
            + "WHERE r.requestID = :requestId")
    List<Shipping> findByRequestId(@Param("requestId") Long requestId) ;

    Optional<Shipping> findById(Long id);
    void deleteById(Long id);
}
