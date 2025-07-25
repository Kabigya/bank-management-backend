package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String status; // e.g. "PENDING", "APPROVED", "REJECTED"

    private Integer tenureMonths;

    private Double interestRate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Loan() {}

    public Loan(Double amount, String status, Integer tenureMonths, Double interestRate, User user) {
        this.amount = amount;
        this.status = status;
        this.tenureMonths = tenureMonths;
        this.interestRate = interestRate;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getTenureMonths() { return tenureMonths; }
    public void setTenureMonths(Integer tenureMonths) { this.tenureMonths = tenureMonths; }
    public Double getInterestRate() { return interestRate; }
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
