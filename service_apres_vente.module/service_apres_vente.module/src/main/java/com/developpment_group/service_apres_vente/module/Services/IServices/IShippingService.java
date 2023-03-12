package com.developpment_group.service_apres_vente.module.Services.IServices;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;

import java.util.List;

public interface IShippingService {

    Shipping createShipping(Shipping shipping);

    Shipping updateShipping(Shipping shipping) ;
    List<Shipping> GetallShippings();

    void GetShippingByID(Long shippingID);
    void clearShipping(Long shippingID);

}
