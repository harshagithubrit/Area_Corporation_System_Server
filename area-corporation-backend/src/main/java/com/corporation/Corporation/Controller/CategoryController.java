package com.corporation.Corporation.Controller;


import com.corporation.Corporation.Entity.Area;
import com.corporation.Corporation.Entity.Category;
import com.corporation.Corporation.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")

public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;
    @PostMapping("Api/Corporation/AddCat")
    public ResponseEntity<?> addCategory (@RequestBody Category obj){
        return new ResponseEntity<>(categoryRepo.save(obj), HttpStatus.OK);
    }

    @GetMapping("Api/Corporation/GetCat")
    public ResponseEntity<?> getCategory (){

        return new ResponseEntity<>(categoryRepo.findAll(), HttpStatus.OK);
    }


    @PutMapping("Api/Corporation/EditCat")
    public ResponseEntity<?> editCat (@RequestBody Category obj){
        var cat = categoryRepo.findById(obj.getCid()).orElseThrow(()->new RuntimeException("Category not found"));
        cat.setCategory(obj.getCategory());
        categoryRepo.save(cat);
        return new ResponseEntity<>("Category updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("Api/Corporation/DeleteCat/{cid}")
    public ResponseEntity<?> deleteCat( @PathVariable Integer cid){
        var cat= categoryRepo.findById(cid).orElseThrow(()-> new RuntimeException("Category not found"));
        categoryRepo.delete(cat);
        return new ResponseEntity<>("Category deleted successfully",HttpStatus.OK);
    }
}
