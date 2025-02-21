package com.indonesianbank.loanapp.repository;

import com.indonesianbank.loanapp.entity.InstalmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalmentTypeRepository extends JpaRepository<InstalmentType, String > {
}
