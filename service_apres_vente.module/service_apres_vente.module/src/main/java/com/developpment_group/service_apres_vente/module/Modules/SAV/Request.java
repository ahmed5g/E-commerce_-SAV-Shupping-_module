package com.developpment_group.service_apres_vente.module.Modules.SAV;

import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    @Column(name = "RequestID")
    private Long requestID;

    private LocalDate requestDate;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @Email(message = "Invalid email address")
    private String customerEmail;

    @NotBlank(message = "Customer address is required")
    private String customerAddress;

    @NotBlank(message = "Order is required")
    private String order;

    @NotBlank(message = "Description is required")
    private String description;

    private Boolean isApproved;



    //Relations

    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    private RequestApproval approval;

    @OneToOne(mappedBy = "requests", cascade = CascadeType.ALL)
    private Shipping shipping;
}
