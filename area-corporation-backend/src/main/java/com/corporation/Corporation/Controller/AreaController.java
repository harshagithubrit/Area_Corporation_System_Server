package com.corporation.Corporation.Controller;

import com.corporation.Corporation.Entity.Area;
import com.corporation.Corporation.Repository.AreaRepo;
import com.corporation.Corporation.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")

public class AreaController {

    @Autowired
    private AreaRepo areaRepo;

    @PostMapping("Api/Corporation/AddArea")
    public ResponseEntity<?> addArea (@RequestBody Area obj){
        return new ResponseEntity<>(areaRepo.save(obj), HttpStatus.OK);
    }

    @GetMapping("Api/Corporation/GetArea")
    public ResponseEntity<?> getArea(){
        return new ResponseEntity<>(areaRepo.findAll(),HttpStatus.OK);
    }

    @PutMapping("Api/Corporation/EditArea")
    public ResponseEntity<?> editArea (@RequestBody Area obj){
        var area = areaRepo.findById(obj.getAid()).orElseThrow(()->new RuntimeException("Area not found"));
        area.setArea(obj.getArea());
        areaRepo.save(area);
        return new ResponseEntity<>("Area updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("Api/Corporation/DeleteArea/{aid}")
    public ResponseEntity<?> deleteArea( @PathVariable Integer aid){
        var area= areaRepo.findById(aid).orElseThrow(()-> new RuntimeException("Area not found"));
        areaRepo.delete(area);
        return new ResponseEntity<>("Area deleted successfully",HttpStatus.OK);
    }
}
