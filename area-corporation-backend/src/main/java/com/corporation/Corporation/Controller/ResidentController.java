package com.corporation.Corporation.Controller;


import com.corporation.Corporation.Entity.Resident;
import com.corporation.Corporation.Repository.ResidentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")

public class ResidentController {


    @Autowired
    public ResidentRepo residentRepo;

    @PostMapping("Api/Corporation/AddResident")
    public ResponseEntity<?> addResident(@RequestBody Resident obj){
        return new ResponseEntity<>(residentRepo.save(obj),HttpStatus.OK);
    }

    @GetMapping("Api/Corporation/GetResident")
    public ResponseEntity<?> getResident(){
     return new ResponseEntity<>(residentRepo.findAll(),HttpStatus.OK) ;
    }


    @GetMapping("Api/Corporation/GetResident/{rid}")
    public ResponseEntity<?> getResident(@PathVariable String rid){
        var resident = residentRepo.findByEmail(rid).orElseThrow(()->new RuntimeException("Resident not found"));
        return new ResponseEntity<>(resident, HttpStatus.OK);
    }
    @PutMapping("Api/Corporation/UpdateResident")
    public ResponseEntity<?> updateResident (@RequestBody Resident obj){
        var resident=residentRepo.findById(obj.getEmail()).orElseThrow(()->new RuntimeException("Resident not found"));
        resident.setStatus(obj.getStatus());
        residentRepo.save(resident);
        return new ResponseEntity<>("Resident verified", HttpStatus.OK);
    }


}
