package com.corporation.Corporation.Repository;

import com.corporation.Corporation.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository <Category, Integer> {
}
