package com.corporation.Corporation.Repository;

import com.corporation.Corporation.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
}
