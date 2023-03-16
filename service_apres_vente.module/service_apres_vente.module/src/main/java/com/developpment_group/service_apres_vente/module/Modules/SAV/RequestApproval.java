package com.developpment_group.service_apres_vente.module.Modules.SAV;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity(name = "RequestApproval")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestApproval implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long approvalId;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Approved_by")
    private String approvedBy;

    @Column(name = "Request_State")
    private status RequestStatus;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Request requests;

}



