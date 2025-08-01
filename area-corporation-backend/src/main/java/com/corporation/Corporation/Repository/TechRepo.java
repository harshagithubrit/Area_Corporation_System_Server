package com.corporation.Corporation.Repository;

import com.corporation.Corporation.Entity.Corporator;
import com.corporation.Corporation.Entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechRepo extends JpaRepository<Technician, Integer> {

    Optional<Technician> findByEmail(String email);

}
