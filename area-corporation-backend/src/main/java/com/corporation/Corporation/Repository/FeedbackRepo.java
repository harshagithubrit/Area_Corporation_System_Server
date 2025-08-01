package com.corporation.Corporation.Repository;

import com.corporation.Corporation.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository <Feedback, Integer> {
}
