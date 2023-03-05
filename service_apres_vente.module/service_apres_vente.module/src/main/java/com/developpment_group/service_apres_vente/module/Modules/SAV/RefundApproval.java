package com.developpment_group.service_apres_vente.module.Modules.SAV;


import jakarta.persistence.*;

import java.time.LocalDate;

enum status{
    APPROVED,
    IN_PROGRESS,
    REJECTED,
}

@Entity(name = "RefundApproval")
public class RefundApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_id")
    private int approvalId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "Request_State")
    private status RequestStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refundRequest_id")
    private RefundRequest refundRequest;



    //Constractor

    public RefundApproval() {
    }

    public RefundApproval(int approvalId, LocalDate date, String approvedBy, status requestStatus, RefundRequest refund) {
        this.approvalId = approvalId;
        this.date = date;
        this.approvedBy = approvedBy;
        RequestStatus = requestStatus;
        refundRequest = refundRequest;
    }


    // getters and setters

    public int getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(int approvalId) {
        this.approvalId = approvalId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public RefundRequest getRefund() {
        return refundRequest;
    }

    public void setRefund(RefundRequest refund) {
        refundRequest = refund;
    }

    public status getRequestStatus() {
        return RequestStatus;
    }

    public void setRequestStatus(status requestStatus) {
        RequestStatus = requestStatus;
    }
}
