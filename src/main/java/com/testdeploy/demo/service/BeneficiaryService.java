package com.testdeploy.demo.service;

import com.testdeploy.demo.model.Beneficiary;
import com.testdeploy.demo.repo.BeneficiaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepo beneficiaryRepo;

    public boolean saveBeneficiary(Beneficiary beneficiary){
        Optional<Beneficiary> beneficiaryOptional = this.beneficiaryRepo.findByCedula(beneficiary.getCedula());
        if(beneficiaryOptional.isPresent()){
            return false;
        }
        this.beneficiaryRepo.save(beneficiary);
        return true;
    }
}
