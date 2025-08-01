package com.corporation.Corporation.Repository;

import com.corporation.Corporation.Entity.Corporator;
import com.corporation.Corporation.Entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResidentRepo extends JpaRepository <Resident, String> {


    Optional<Resident> findByEmail(String email);
}
