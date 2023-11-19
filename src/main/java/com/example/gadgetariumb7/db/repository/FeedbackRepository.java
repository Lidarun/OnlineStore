package com.example.gadgetariumb7.db.repository;

import com.example.gadgetariumb7.db.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
