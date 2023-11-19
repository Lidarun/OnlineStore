package com.example.gadgetariumb7.db.repository;

import com.example.gadgetariumb7.db.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}