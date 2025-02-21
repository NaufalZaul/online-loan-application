package com.indonesianbank.loanapp.entity;


import com.indonesianbank.loanapp.constant.CustomerStatus;
import com.indonesianbank.loanapp.constant.DBBash;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = DBBash.CUSTOMER_DB)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "phone", nullable = false, length = 13)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, updatable = true)
    private CustomerStatus status;

    //    private User user;
}

