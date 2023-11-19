package com.example.gadgetariumb7.db.repository;

import com.example.gadgetariumb7.db.entity.Product;
import com.example.gadgetariumb7.db.entity.Review;
import com.example.gadgetariumb7.db.entity.User;
import com.example.gadgetariumb7.dto.response.ReviewResponse;
import com.example.gadgetariumb7.dto.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select count(productGrade) from Review where productGrade = :productGrade ")
    int countReviewByProductGrade(double productGrade);

    @Query("select count(r) from Review r where r.statusOfResponse = false ")
    int countReviewUnAnswered();

    @Query("select r.user from Review r where r.id = :id")
    User getUserReview(Long id);

    @Query("select r.product from Review r where r.id=:id")
    Product getProductReview(Long id);


    @Query("select new com.example.gadgetariumb7.dto.response.UserResponse(" +
            "r.user.id," +
            "r.user.firstName," +
            "r.user.lastName," +
            "r.user.email," +
            "r.user.image) from  Review  r")
    UserResponse getUser();

    @Query("select new com.example.gadgetariumb7.dto.response.ReviewResponse(" +
            "r.id," +
            "r.userReview," +
            "r.responseOfReview," +
            "r.reviewTime," +
            "r.productGrade) from Review r")
    List<ReviewResponse> getAllByAdmin();

    @Query("select new com.example.gadgetariumb7.dto.response.ReviewResponse(" +
            "r.id," +
            "r.userReview," +
            "r.responseOfReview," +
            "r.reviewTime," +
            "r.productGrade) from Review r where r.statusOfResponse = false")
    List<ReviewResponse> getAllReviewByStatusOfResponseFalse();

    @Query("select new com.example.gadgetariumb7.dto.response.ReviewResponse(" +
            "r.id," +
            "r.userReview," +
            "r.responseOfReview," +
            "r.reviewTime," +
            "r.productGrade) from Review r where r.statusOfResponse = true")
    List<ReviewResponse> getAllReviewByStatusTrue();

    @Query("select count(id) from Review where product.id = :productId and productGrade = :grade")
    int getCountReviewOfProduct(Long productId, double grade);
}
