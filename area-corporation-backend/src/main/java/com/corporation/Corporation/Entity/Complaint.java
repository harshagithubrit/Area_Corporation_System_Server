package com.corporation.Corporation.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cplid;
    private String resident;
    private String mobile;
    private String address;
    private String area;
    private String category;
    private String complaint;
    private String technician;
    private String reason;
    private int progress;

    @Column(columnDefinition = "LONGTEXT")
    private String image;

    @Column(columnDefinition = "LONGTEXT")
    private String image2;

}
