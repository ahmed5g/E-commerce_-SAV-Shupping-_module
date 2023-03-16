package com.developpment_group.service_apres_vente.module.Modules.SAV;

import com.developpment_group.service_apres_vente.module.Modules.Shipping.Shipping;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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



    @OneToOne(mappedBy = "requests", cascade = CascadeType.ALL)
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
