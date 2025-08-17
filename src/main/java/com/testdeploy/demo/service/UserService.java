package com.testdeploy.demo.service;

import com.testdeploy.demo.model.User;
import com.testdeploy.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BeneficiaryService beneficiaryService;



    public ResponseEntity<User> saveUser(User newUser){
        Optional<User> userFound = userRepo.findByEmail(newUser.getCorreo());
        if(userFound.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        if(beneficiaryService.saveBeneficiary(newUser.getBeneficiary())){
            User newCreatedUser = new User(newUser.getNombre(), newUser.getCorreo(),newUser.getBeneficiary(), newUser.getCedula());
            this.userRepo.save(newCreatedUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCreatedUser);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }


    public ResponseEntity<List<User>> listUsers(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.userRepo.findAll());
    }


    public HttpStatus deleteUser(User user){
        Optional<User> userFound = this.userRepo.findById(user.getId());
        if(userFound.isPresent()){
            this.userRepo.delete(user);
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.NOT_FOUND;
    }
}
