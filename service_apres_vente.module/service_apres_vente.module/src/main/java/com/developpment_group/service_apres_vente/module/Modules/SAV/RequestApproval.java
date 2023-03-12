package com.developpment_group.service_apres_vente.module.Modules.SAV;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

enum status{
    APPROVED,
    IN_PROGRESS,
    REJECTED,
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

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "Request_State")
    private status RequestStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Request")

    private Request requests;




    //Constractor


    public RequestApproval() {
    }

    public RequestApproval(Long approvalId, LocalDate date, String approvedBy, status requestStatus, Request request) {
        this.approvalId = approvalId;
        this.date = date;
        this.approvedBy = approvedBy;
        RequestStatus = requestStatus;
        this.request = request;
    }

    //Generate Getters and setters


    public long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
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

    public status getRequestStatus() {
        return RequestStatus;
    }

    public void setRequestStatus(status requestStatus) {
        RequestStatus = requestStatus;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    //To string


    @Override
    public String toString() {
        return "RequestApproval{" +
                "approvalId=" + approvalId +
                ", date=" + date +
                ", approvedBy='" + approvedBy + '\'' +
                ", RequestStatus=" + RequestStatus +
                ", request=" + request +
                '}';
    }

}
