package com.developpment_group.service_apres_vente.module.Modules.SAV;


import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import jakarta.persistence.*;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.lang.NonNullFields;

import java.time.LocalDate;


@Entity(name = "Request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Request_ID")
    private Long requestID;

    @Column(name = "Request_date")
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

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")*/


    /*@OneToMany(mappedBy = "RefundRequest", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;*/


    ////////////////////////////////////////////////////////////////

    /*@OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    private RefundApproval approval;*/


    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    private RequestApproval approval;


    @OneToOne(mappedBy = "requests_ship", cascade = CascadeType.ALL)
    private Shipping shipping;


}
