package com.aurionpro.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	@Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @NotBlank(message = "Sender account number is required")
    @Column()
    private String senderAccno;

    @Column()
    private String receiverAccno;

    @Min(value = 1, message = "Amount must be at least 1")
    @Column()
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column()
    private TransactionType transactionType;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Column()
    private String description;

    @Column()
    private LocalDateTime transactionDate;
}






