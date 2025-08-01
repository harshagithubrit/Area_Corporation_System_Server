package com.corporation.Corporation.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Feedback {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int fid;
    private String resident;
    private String mobile;
    private String address;
    private String feedback;
}
