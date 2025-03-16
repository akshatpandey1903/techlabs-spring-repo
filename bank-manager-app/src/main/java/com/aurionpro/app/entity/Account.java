package com.aurionpro.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String accountNo; // Custom-generated
    
    @Column
    @Min(value = 500, message = "Minimum balance must be 500.0")
    private Double balance;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}









