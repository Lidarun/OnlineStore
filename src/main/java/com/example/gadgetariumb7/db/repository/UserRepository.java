package com.example.gadgetariumb7.db.repository;

import com.example.gadgetariumb7.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("select case when count(u)>0 then true else false end from User u where u.email like :email")
    boolean existsByEmail(@Param(value = "email") String email);

    @Query(value = "select favorites_list_id from users_favorites_list where user_id = :userId", nativeQuery = true)
    List<Long> getAllFavoritesByUserId(Long userId);

}