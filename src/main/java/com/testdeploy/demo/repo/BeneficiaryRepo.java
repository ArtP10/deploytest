package com.testdeploy.demo.repo;

import com.testdeploy.demo.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long> {
    Optional<Beneficiary> findByCedula(String cedula);
}
