package com.example.miniapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")  // Specify the custom table name
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String paymentMethod;
    private Boolean paymentStatus;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    // Constructors
    public Payment() {}

    public Payment(Double amount, String paymentMethod, Boolean paymentStatus) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Payment(Long id, Double amount, String paymentMethod, Boolean paymentStatus, Trip trip) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.trip = trip;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public Trip getTrip() {
        return trip;
    }
    // (Use Lombok @Data or manually write if Lombok isn't in use)
}
