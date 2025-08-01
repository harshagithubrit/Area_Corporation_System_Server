package com.corporation.Corporation.Entity;

import jakarta.persistence.Entity;
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

public class Resident {

    @Id
    private String email;
    private  String mobile;
    private String name;
    private String status;


    private String address;
    private String password;


}
