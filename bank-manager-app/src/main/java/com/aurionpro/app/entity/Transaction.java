package com.aurionpro.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @NotBlank(message = "Sender account number is required")
    @Column(nullable = false, length = 12)
    private String senderAccno;

    @Column(length = 12)
    private String receiverAccno;

    @Min(value = 1, message = "Amount must be at least 1")
    @Column(nullable = false)
    private Double amount;

    @NotBlank(message = "Transaction type is required")
    @Column(nullable = false)
    private String transactionType;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime transactionDate;
}






