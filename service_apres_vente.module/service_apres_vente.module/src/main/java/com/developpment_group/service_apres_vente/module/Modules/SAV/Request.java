package com.developpment_group.service_apres_vente.module.Modules.SAV;


import jakarta.persistence.*;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;


@Entity(name = "Request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Request_ID")
    private Long requestID;

    @Column(name = "Request_date")
    private LocalDate requestDate;

    @Column(name = "Customer_Name")
    private String customerName;

    @Column(name = "Customer_Email")
    private String customerEmail;

    @Column(name = "Customer_Address")
    private String customerAdress;


    @Column(name = "Order_ID")
    private String order;


    @Column(name = "Request_Description")
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


    //Generate Constructor

    public Request() {
    }
    public Request(Long requestID, LocalDate requestDate, String customerName, String customerEmail, String customerAdress, String order, String description, Boolean isApproved) {
        this.requestID = requestID;
        this.requestDate = requestDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAdress = customerAdress;
        this.order = order;
        Description = description;
        this.isApproved = isApproved;
    }


    //Generate Getters and setters

    public Long getRequestID() {
        return requestID;
    }

    public void setRequestID(Long requestID) {
        this.requestID = requestID;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }


    public RequestApproval getApproval() {
        return approval;
    }

    public void setApproval(RequestApproval approval) {
        this.approval = approval;
    }

    //To String

    @Override
    public String toString() {
        return "Request{" +
                "requestID=" + requestID +
                ", requestDate=" + requestDate +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAdress='" + customerAdress + '\'' +
                ", order='" + order + '\'' +
                ", Description='" + Description + '\'' +
                ", isApproved=" + isApproved +
                '}';
    }
}
