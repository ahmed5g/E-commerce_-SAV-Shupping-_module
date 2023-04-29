package com.developpment_group.service_apres_vente.module.Services.Shipping;

import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import com.developpment_group.service_apres_vente.module.Repositories.RequestRepo;
import com.developpment_group.service_apres_vente.module.Repositories.ShippingRepo;
import com.developpment_group.service_apres_vente.module.Services.IServices.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService implements IShippingService {

    @Autowired
    private ShippingRepo ShippingRepo;
    @Autowired
    private RequestRepo requestRepo;


    @Override
    public Shipping createShipping(Shipping shipping) {
        return ShippingRepo.save(shipping);
    }


    //
    @Override
    public Shipping updateShipping(Shipping shipping) {
        try {
            Long id = shipping.getShipping_ID();
            Optional<Shipping> existingRequest = ShippingRepo.findById(id);
            if (existingRequest.isPresent()) {
                Shipping updatedShipping = existingRequest.get();
                updatedShipping.setSender_address(shipping.getSender_address());
                updatedShipping.setRecipient_address(shipping.getRecipient_address());
                updatedShipping.setShipping_cost(shipping.getShipping_cost());
                updatedShipping.setShipping_date(shipping.getShipping_date());
                updatedShipping.setTracking_number(shipping.getTracking_number());
                updatedShipping.setReplacement_item(shipping.getReplacement_item());
                updatedShipping.setDelivery_status(shipping.getDelivery_status());
                updatedShipping.setRequests(shipping.getRequests());
                updatedShipping.setShipping_ID(shipping.getShipping_ID());
                return ShippingRepo.save(updatedShipping);
            } else {
                throw new RuntimeException("Shipping with ID " + id + " not found");
            }
        } catch (Exception e) {
            // Handle any exceptions thrown during the update process
            e.printStackTrace();
            throw new RuntimeException("Failed to update Request: " + e.getMessage());
        }

    }

    @Override
    public List<Shipping> GetallShippings() {
        return ShippingRepo.findAll();
    }

    @Override
    public void GetShippingByID(Long shippingID) {
        ShippingRepo.findById(shippingID);

    }

    @Override
    public void clearShipping(Long shippingID) {
        ShippingRepo.deleteById(shippingID);

    }

    public Object readShipping(Shipping requestID) {
        return ShippingRepo.findByRequests_RequestID(requestID);
    }
}
