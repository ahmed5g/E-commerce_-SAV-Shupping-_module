package com.developpment_group.service_apres_vente.module.Modules.SAV;


import jakarta.persistence.*;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.Date;


@Entity(name = "refundRequest")
public class RefundRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refund_id")
    private Long refundId;

    @Column(name = "refund_date")
    private LocalDate refundDate;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "reason")
    private String reason;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")*/

    @Column(name = "Order_ID")
    private String order;

    /*@OneToMany(mappedBy = "RefundRequest", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;*/
    @Column(name = "Ordered_Items")
    private String OrderItems;

    @Column(name = "status")
    private String status;

    @OneToOne(mappedBy = "refundRequest", cascade = CascadeType.ALL)
    private RefundApproval approval;


    public RefundRequest() {
    }

    public RefundRequest(Long refundId, LocalDate refundDate, Long clientId, String reason, String order, String orderItems, String status, RefundApproval approval) {
        this.refundId = refundId;
        this.refundDate = refundDate;
        this.clientId = clientId;
        this.reason = reason;
        this.order = order;
        OrderItems = orderItems;
        this.status = status;
        this.approval = approval;
    }

    //Getters and Setters
    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public LocalDate getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(LocalDate refundDate) {
        this.refundDate = refundDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RefundApproval getApproval() {
        return approval;
    }

    public void setApproval(RefundApproval approval) {
        this.approval = approval;
    }
}
