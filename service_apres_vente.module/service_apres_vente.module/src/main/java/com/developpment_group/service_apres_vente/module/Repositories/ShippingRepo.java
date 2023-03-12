package com.developpment_group.service_apres_vente.module.Repositories;

import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepo extends JpaRepository<Shipping, Long> {
}
