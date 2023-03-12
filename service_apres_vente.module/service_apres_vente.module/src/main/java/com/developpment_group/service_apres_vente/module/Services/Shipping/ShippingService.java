package com.developpment_group.service_apres_vente.module.Services.Shipping;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import com.developpment_group.service_apres_vente.module.Repositories.ShippingRepo;
import com.developpment_group.service_apres_vente.module.Services.IServices.IShippingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShippingService implements IShippingService {

    private ShippingRepo ShippingRepo;


    @Override
    public Shipping createShipping(Shipping shipping) {
        return ShippingRepo.save(shipping);
    }


    //
    @Override
    public Shipping updateShipping(Shipping shipping) {
        try {
            Long requestID = shipping.getRequests_ship().getRequestID();
            List<Shipping> existingShippings = ShippingRepo.findByRequestId(requestID);
            if (!existingShippings.isEmpty()) {
                Shipping existingShipping = existingShippings.get(0);
                existingShipping.setRequests_ship(shipping.getRequests_ship());
                existingShipping.setRecipient_address(shipping.getRecipient_address());
                existingShipping.setSender_address(shipping.getSender_address());
                existingShipping.setShipping_date(shipping.getShipping_date());
                existingShipping.setShipping_cost(shipping.getShipping_cost());
                existingShipping.setDelivery_status(shipping.getDelivery_status());
                existingShipping.setReplacement_item(shipping.getReplacement_item());
                existingShipping.setTracking_number(shipping.getTracking_number());
                return ShippingRepo.save(existingShipping);
            } else {
                throw new EntityNotFoundException("Shipping with requestID " + requestID + " not found");
            }
        } catch (Exception e) {
            // Handle any exceptions thrown during the update process
            e.printStackTrace();
            throw new RuntimeException("Failed to update Shipping: " + e.getMessage());
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

    public Object readShipping(Long requestID) {
        return ShippingRepo.findByRequestId(requestID);
    }
}
