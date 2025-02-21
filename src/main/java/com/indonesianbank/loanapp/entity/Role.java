package com.indonesianbank.loanapp.entity;

import com.indonesianbank.loanapp.constant.DBBash;
import com.indonesianbank.loanapp.constant.ERole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = DBBash.ROLE_DB)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ERole role;
}
