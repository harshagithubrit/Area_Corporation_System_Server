package com.corporation.Corporation.Controller;


import com.corporation.Corporation.Entity.Feedback;
import com.corporation.Corporation.Repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")


public class FeedbackController {

    @Autowired
    private FeedbackRepo feedbackRepo;


    @PostMapping("Api/Corporation/PostFeedback")
    public ResponseEntity<?> postFeedback (@RequestBody Feedback obj){
        return new ResponseEntity<>(feedbackRepo.save(obj), HttpStatus.OK);
    }


    @GetMapping("Api/Corporation/GetFeedback")
    public ResponseEntity<?> getArea(){
        return new ResponseEntity<>(feedbackRepo.findAll(),HttpStatus.OK);
    }
}
