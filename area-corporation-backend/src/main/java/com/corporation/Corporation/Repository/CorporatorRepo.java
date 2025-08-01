package com.corporation.Corporation.Repository;

import com.corporation.Corporation.Entity.Corporator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorporatorRepo extends JpaRepository<Corporator, Integer> {

    Optional<Corporator> findByEmail(String email);

    boolean existsByArea(String Area);
}
