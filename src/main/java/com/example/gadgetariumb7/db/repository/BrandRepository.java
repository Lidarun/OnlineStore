package com.example.gadgetariumb7.db.repository;

import com.example.gadgetariumb7.db.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}