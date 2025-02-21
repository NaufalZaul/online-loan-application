package com.indonesianbank.loanapp.entity;

import com.indonesianbank.loanapp.constant.DBBash;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = DBBash.LOAN_TYPE_DB)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "type")
    private String type;

    @Column(name = "max_loan")
    private Double maxLoan;
}
