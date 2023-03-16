package com.developpment_group.service_apres_vente.module.Modules.SAV;


import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import jakarta.persistence.*;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity(name = "Request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long requestID;

    @Column(name = "Date")
    private LocalDate requestDate;

    @NotNull
    @Column(name = "Customer_Name")
    private String customerName;



    @Column(name = "Customer_Email")
    @Email
    private String customerEmail;


    @Column(name = "Customer_Address")
    @NotNull
    private String customerAdress;


    @Column(name = "Order_ID")
    @NotNull
    private String order;


    @Column(name = "Request_Description")
    @NotNull
    private String Description;


    @Column(name = "IsApproved")
    private Boolean isApproved;



    @OneToOne(mappedBy = "requests_ship", cascade = CascadeType.ALL)
    private Shipping shipping;

    public boolean setApprovalStatus(status requestStatus) {
        if (requestStatus == status.APPROVED) {
            this.isApproved = true;
            return true;
        } else {
            this.isApproved = false;
            return false;
        }
    }


}
