package com.developpment_group.service_apres_vente.module.Modules.SAV;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

enum status {
    APPROVED, IN_PROGRESS, REJECTED,
}

@Entity(name = "RequestApproval")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_id")
    private Long approvalId;
    private LocalDate date;
    private String approvedBy;
    private status RequestStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Request")
    private Request requests;

}
