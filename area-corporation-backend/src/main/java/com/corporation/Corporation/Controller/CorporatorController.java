package com.corporation.Corporation.Controller;

import com.corporation.Corporation.Entity.Corporator;
import com.corporation.Corporation.Entity.Technician;
import com.corporation.Corporation.Repository.CorporatorRepo;
import com.corporation.Corporation.Repository.TechRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin("http://localhost:3000")

public class CorporatorController {

    @Autowired
    private CorporatorRepo corporatorRepo;


    @PostMapping("Api/Corporation/AddCor")
    public ResponseEntity<?> addCor (@RequestBody Corporator obj) {
        if(corporatorRepo.existsByArea(obj.getArea())){
            throw new RuntimeException("Corporator already exits with selected area");
        }
        Random rnd = new Random();
        var password = rnd.nextInt(1000,9999);
        obj.setPassword(String.valueOf(password));
        return new ResponseEntity<>(corporatorRepo.save(obj), HttpStatus.OK);
    }

    @GetMapping("Api/Corporation/GetCor")
    public ResponseEntity<?> getCorp(){
        return new ResponseEntity(corporatorRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("Api/Corporation/GetCor/{cid}")
    public ResponseEntity<?> getCorp(@PathVariable String cid){
        var corporator = corporatorRepo.findByEmail(cid).orElseThrow(()->new RuntimeException("Corporator not found"));
        return new ResponseEntity<>(corporator, HttpStatus.OK);
    }

    @PutMapping("Api/Corporation/UpdatePassword/{email}")
    public ResponseEntity<?> updatePassword(@RequestBody Corporator obj, @PathVariable String email ){
       var corporator = corporatorRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Corporator not found"));
        corporator.setPassword(obj.getPassword());
        corporatorRepo.save(corporator);
        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
    }


    @PutMapping("Api/Corporation/UpdateProfile/{email}")
    public ResponseEntity<?> updateProfile(@RequestBody Corporator obj, @PathVariable String email ){
        var corporator = corporatorRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Corporator not found"));
        corporator.setName(obj.getName());
        corporator.setMobile(obj.getMobile());
        corporator.setAddress(obj.getAddress());
        corporatorRepo.save(corporator);
        return new ResponseEntity<>("Profile updated successfully", HttpStatus.OK);
    }
}
