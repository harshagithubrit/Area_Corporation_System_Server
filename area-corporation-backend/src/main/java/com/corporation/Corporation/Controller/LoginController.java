package com.corporation.Corporation.Controller;


import com.corporation.Corporation.Repository.AdminRepo;
import com.corporation.Corporation.Repository.CorporatorRepo;
import com.corporation.Corporation.Repository.ResidentRepo;
import com.corporation.Corporation.Repository.TechRepo;
import com.corporation.Corporation.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")

public class LoginController {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ResidentRepo residentRepo;

    @Autowired
    private TechRepo techRepo;


    @Autowired
    private CorporatorRepo corporatorRepo;


    @PostMapping("Api/Corporation/UserLogin")
    public ResponseEntity<?> UserLogin(@RequestBody UserDto obj) {
        if (obj.getUsertype().equals("Admin")) {
            var admin = adminRepo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("User not found"));
            if (admin.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Admin", HttpStatus.OK);
            } else {
                throw new RuntimeException("Invalid Password");
            }
        }
        else if(obj.getUsertype().equals("Area Corporator")) {
            var corporator = corporatorRepo.findByEmail(obj.getId()).orElseThrow(() -> new RuntimeException("Corporator not found"));
            if (corporator.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Area Corporator", HttpStatus.OK);
            } else {
                throw new RuntimeException("Invalid Password");
            }
        }
        else if(obj.getUsertype().equals("Technician")) {
            var technician = techRepo.findByEmail(obj.getId()).orElseThrow(() -> new RuntimeException("Technician not found"));
            if (technician.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Technician", HttpStatus.OK);
            } else {
                throw new RuntimeException("Invalid Password");
            }
        }

            else if(obj.getUsertype().equals("Area Resident")){
                var resident = residentRepo.findById(obj.getId()).orElseThrow(()-> new RuntimeException("Resident not found"));
            if(resident.getStatus().equals("pending")) throw new RuntimeException("Your profile not yet verified by Admin..! Comeback later");
                if(resident.getPassword().equals(obj.getPassword())){
                    return new ResponseEntity<>("Area Resident", HttpStatus.OK);
                }
                else {
                    throw new RuntimeException("Invalid Password");
                }

            }
        else {
            throw new RuntimeException("Select User Type");
        }
    }
}
