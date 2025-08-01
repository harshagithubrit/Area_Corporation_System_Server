package com.corporation.Corporation.Controller;


import com.corporation.Corporation.Entity.Complaint;
import com.corporation.Corporation.Repository.ComplaintRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:3000")


public class ComplaintController {

    @Autowired
    private ComplaintRepo complaintRepo;

    @PostMapping("Api/Corporation/PostComplaint")
    public ResponseEntity<?> postComplaint(@RequestBody Complaint obj) {
        return new ResponseEntity<>(complaintRepo.save(obj), HttpStatus.OK);
    }

    @PutMapping("Api/Corporation/AssignTech/{cplid}")
    public ResponseEntity<?> assignTech(@PathVariable Integer cplid, @RequestBody @NotNull Complaint obj) {
        var complaint = complaintRepo.findById(cplid).orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setTechnician(obj.getTechnician());
        return new ResponseEntity<>(complaintRepo.save(complaint), HttpStatus.CREATED);
    }

    @PutMapping("Api/Corporation/UpdateProgress/{cplid}")
    public ResponseEntity<?> updateProgress(@PathVariable Integer cplid, @RequestBody @NotNull Complaint obj) {
        var complaint = complaintRepo.findById(cplid).orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setProgress(obj.getProgress());
        complaint.setReason(obj.getReason());
        complaint.setImage2(obj.getImage2());
        return new ResponseEntity<>(complaintRepo.save(complaint), HttpStatus.CREATED);
    }

    @GetMapping("Api/Corporation/GetComplaint")
    public ResponseEntity<?> getComplaint() {
        return new ResponseEntity<>(complaintRepo.findAll(), HttpStatus.OK);
    }
}


