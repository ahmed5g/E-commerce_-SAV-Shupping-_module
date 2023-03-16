package com.developpment_group.service_apres_vente.module.Modules.Shipping;

import com.developpment_group.service_apres_vente.module.Modules.SAV.Request;
import com.developpment_group.service_apres_vente.module.Modules.SAV.RequestApproval;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity(name = "Shipping")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Shipping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Shipping_ID;

    @Column(name = "Shipping_date")
    private LocalDate Shipping_date;


    //address of the store from which the package is sent
    @NotNull
    @Column(name = "sender_address")
    private String sender_address;

    //address of the customer who ordered the package
    @NotNull
    @Column(name = "recipient_address")
    private String recipient_address;

    @NotNull
    @Column(name = "Tracking_number")
    private String Tracking_number;


    @NotNull
    @Column(name = "shipping_cost")
    private Float shipping_cost;


    @NotNull
    @Column(name = "Items")
    private String replacement_item;


    private status delivery_status;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Requests")
    private Request requests_ship;



}
