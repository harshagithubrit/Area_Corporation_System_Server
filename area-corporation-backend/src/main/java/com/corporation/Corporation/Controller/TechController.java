package com.corporation.Corporation.Controller;


import com.corporation.Corporation.Entity.Corporator;
import com.corporation.Corporation.Entity.Technician;
import com.corporation.Corporation.Repository.TechRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin("http://localhost:3000")


public class TechController {


    @Autowired
    private TechRepo techRepo;


    @PostMapping("Api/Corporation/AddTech")
    public  ResponseEntity<?> addTech (@RequestBody Technician obj) {
        Random rnd = new Random();
        var password = rnd.nextInt(1000,9999);
        obj.setPassword(String.valueOf(password));
        return new ResponseEntity<>(techRepo.save(obj), HttpStatus.OK);
    }

    @GetMapping("Api/Corporation/GetTech")
    public ResponseEntity<?> getTech(){
        return new ResponseEntity(techRepo.findAll(),HttpStatus.OK);
    }


    @GetMapping("Api/Corporation/GetTech/{tid}")
    public ResponseEntity<?> getTech(@PathVariable String tid){
        var technician = techRepo.findByEmail(tid).orElseThrow(()->new RuntimeException("Technician not found"));
        return new ResponseEntity<>(technician, HttpStatus.OK);
    }


    @PutMapping("Api/Corporation/UpdateTechProfile/{email}")
    public ResponseEntity<?> updateTechProfile(@RequestBody Technician obj, @PathVariable String email ){
        var technician = techRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Technician not found"));
        technician.setName(obj.getName());
        technician.setMobile(obj.getMobile());
        technician.setAddress(obj.getAddress());
        techRepo.save(technician);
        return new ResponseEntity<>("Profile updated successfully", HttpStatus.OK);
    }

    @PutMapping("Api/Corporation/UpdateTechPassword/{email}")
    public ResponseEntity<?> updatePassword(@RequestBody Technician obj, @PathVariable String email ){
        var technician = techRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Technician not found"));
        technician.setPassword(obj.getPassword());
        techRepo.save(technician);
        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
    }


}
