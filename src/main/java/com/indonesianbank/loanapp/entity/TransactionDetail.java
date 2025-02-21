package com.indonesianbank.loanapp.entity;

import com.indonesianbank.loanapp.constant.DBBash;
import com.indonesianbank.loanapp.constant.LoanStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = DBBash.TRANSACTION_DETAIL_DB)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "transaction_date")
    private Long transactionDate;

    @Column(name = "nominal")
    private Double nominal;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @Enumerated(EnumType.STRING)
    @Column(name = "loan_status")
    private LoanStatus loanStatus;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;
}

