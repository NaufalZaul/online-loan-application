package com.indonesianbank.loanapp.entity;

import com.indonesianbank.loanapp.constant.DBBash;
import com.indonesianbank.loanapp.constant.EInstalmentType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = DBBash.INSTALMENT_TYPE_DB)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class InstalmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "instalment_type")
    private EInstalmentType instalmentType;
}

