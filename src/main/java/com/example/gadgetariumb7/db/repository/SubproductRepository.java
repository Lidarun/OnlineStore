package com.example.gadgetariumb7.db.repository;

import com.example.gadgetariumb7.db.entity.Subproduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubproductRepository extends JpaRepository<Subproduct, Long> {
    @Query(nativeQuery = true, value = "select subproduct_id from user_basket_list where user_id = :userId order by subproduct_id desc")
    List<Long> getAllFromUserBasketList(Long userId);
}