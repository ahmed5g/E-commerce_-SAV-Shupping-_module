package com.developpment_group.service_apres_vente.module.Controllers.SAVController;

import com.developpment_group.service_apres_vente.module.Common.ApiResponse;
import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import com.developpment_group.service_apres_vente.module.Services.SAVService.RequestService;
import com.developpment_group.service_apres_vente.module.Services.Shipping.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/Shipping")
public class ShippingController {

    @Autowired
    private ShippingService Shipping_Service;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createRequest(@Validated @RequestBody Shipping shipping) {
        if (Objects.nonNull(Shipping_Service.readShipping(shipping.getRequests_ship().getRequestID()))) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Shipping already linked with Request"), HttpStatus.CONFLICT);
        }
        Shipping_Service.createShipping(shipping);
        return new ResponseEntity<>(new ApiResponse(true, "Shipping has been successfully Added"), HttpStatus.CREATED);
    }

    @GetMapping("/ALL")
    public List<Shipping> ShippingList(){
        return Shipping_Service.GetallShippings();
    }

    @GetMapping("/{Request-ID}")
    public void retriveShippingByID(@PathVariable("Request-ID") Long Request_ID){Shipping_Service.GetShippingByID(Request_ID);    }

    @PutMapping("/update")
    public Shipping updateShipping(@RequestBody Shipping shipping){
        return Shipping_Service.updateShipping(shipping);
    }

    @DeleteMapping("/delete/{shippingID}")
    public void deleteShipping(@PathVariable("shippingID") Long shippingID){
        Shipping_Service.clearShipping(shippingID);
    }
}
