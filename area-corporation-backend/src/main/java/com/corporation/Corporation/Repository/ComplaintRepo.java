package com.corporation.Corporation.Repository;

import com.corporation.Corporation.Entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepo extends JpaRepository<Complaint,Integer> {
}
