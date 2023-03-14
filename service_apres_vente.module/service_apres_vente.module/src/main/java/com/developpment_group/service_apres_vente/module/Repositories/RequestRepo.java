package com.developpment_group.service_apres_vente.module.Repositories;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepo extends JpaRepository<Request,Long> {
    Request findByOrder(String order);

    Optional<Request> findById(Long requestID);
    void deleteById(Long id);

    List<Request> findByIsApproved(boolean isApproved, Sort sort);
}
