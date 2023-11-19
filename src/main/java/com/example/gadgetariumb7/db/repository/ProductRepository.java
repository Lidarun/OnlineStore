package com.example.gadgetariumb7.db.repository;

import com.example.gadgetariumb7.db.entity.Product;
import com.example.gadgetariumb7.dto.response.ProductCardResponse;
import com.example.gadgetariumb7.dto.response.ProductAdminResponse;
import com.example.gadgetariumb7.dto.response.ProductSearchResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Query("select new com.example.gadgetariumb7.dto.response.ProductCardResponse " +
            "(p.id," +
            "p.productImage," +
            "p.productName, " +
            "p.productCount," +
            "p.productPrice," +
            "p.productStatus," +
            "p.productRating)" +
            "from Product p where p.productStatus = 0 order by p.id desc")
    List<ProductCardResponse> getAllNewProduct(Pageable pageable);

    @Query("select new com.example.gadgetariumb7.dto.response.ProductCardResponse " +
            "(p.id," +
            "p.productImage," +
            "p.productName, " +
            "p.productCount," +
            "p.productPrice," +
            "p.productStatus," +
            "p.productRating" +
            "" +
            ")" +
            "from Product p where p.discount is not null order by p.id desc")
    List<ProductCardResponse> getAllDiscountProduct(Pageable pageable);

    @Query("select (p.productPrice -((p.productPrice * p.discount.amountOfDiscount) /100)) from Product p  where p.id = :id ")
    int getDiscountPrice(Long id);

    @Query("select count (r.product) from Review r where r.product.id =:id")
    int getAmountOfFeedback(Long id);

    @Query("select new com.example.gadgetariumb7.dto.response.ProductCardResponse " +
            "(p.id," +
            "p.productImage," +
            "p.productName, " +
            "p.productCount," +
            "p.productPrice," +
            "p.productStatus," +
            "p.productRating)" +
            " from Product p where p.productStatus = 1 order by p.id desc")
    List<ProductCardResponse> getAllRecommendationProduct(Pageable pageable);

    @Query(nativeQuery = true, value = "select sum(o.count_of_product) from orders o where o.order_status like 'DELIVERED'")
    int getCountSoldProducts();

    @Query(nativeQuery = true, value = "select sum(o.total_sum) from orders o where o.order_status like 'DELIVERED'")
    Long getSoldProductPrice();

    @Query(nativeQuery = true, value = "select sum(o.count_of_product) from orders o where o.order_status in ('WAITING', 'ORDER_READY', 'ON_THE_WAY', 'IN_PROCESSING')")
    int getCountOrderProduct();

    @Query(nativeQuery = true, value = "select sum(o.total_sum) from orders o where o.order_status in ('WAITING', 'ORDER_READY', 'ON_THE_WAY', 'IN_PROCESSING')")
    Long getOrderProductPrice();

    @Query(nativeQuery = true, value = "select sum(o.total_sum) from orders o where o.order_status like 'DELIVERED' and o.date_of_order between date(now()) and date(now()) + interval '1' day")
    Long getCurrentPeriodPerDay();

    @Query(nativeQuery = true, value = "select sum(o.total_sum) from orders o where o.order_status like 'DELIVERED' and o.date_of_order between date(now()) - interval '1' day and date(now()) - interval '1' second")
    Long getPreviousPeriodPerDay();

    @Query(nativeQuery = true, value = "select sum(o.total_sum) from orders o where o.order_status like 'DELIVERED' and o.date_of_order between date_trunc('month', now()) and date_trunc('month', now()) + interval '1' MONTH - interval '1' second")
    Long getCurrentPeriodPerMonth();

    @Query(nativeQuery = true, value = "select sum(o.total_sum) from orders o where o.order_status like 'DELIVERED' and o.date_of_order between date_trunc('year', now()) and date_trunc('year', now()) + interval '1' year - interval '1' second")
    Long getCurrentPeriodPerYear();

    @Query(nativeQuery = true, value = "select sum(o.total_sum) from orders o where o.order_status like 'DELIVERED' and o.date_of_order between date_trunc('month', now() - interval '1' month) and date_trunc('month', now()) - interval '1' second")
    Long getPreviousPeriodPerMonth();

    @Query(nativeQuery = true, value = "select sum(o.total_sum) from orders o where o.order_status like 'DELIVERED' and o.date_of_order between date_trunc('year', now() - INTERVAL '1' year) and date_trunc('year', now()) - interval '1' second")
    Long getPreviousPeriodPerYear();

    @Query("select new com.example.gadgetariumb7.dto.response.ProductAdminResponse" +
            "(id," +
            "productImage," +
            "productVendorCode," +
            "productName," +
            "productCount," +
            "subproducts.size," +
            "createAt," +
            "productPrice," +
            "productStatus," +
            "dateOfIssue" +
            ") from Product")
    List<ProductAdminResponse> getAllProductsAdmin(Pageable pageable);

    @Query("select count(id) from Product")
    int getCountOfProducts();

    @Query("select new com.example.gadgetariumb7.dto.response.ProductAdminResponse" +
            "(p.id," +
            "p.productImage," +
            "p.productVendorCode," +
            "p.productName," +
            "p.productCount," +
            "p.subproducts.size," +
            "p.createAt," +
            "p.productPrice," +
            "p.productStatus" +
            ") from Product p where " +
            "cast(p.productVendorCode as string) like upper(concat(:text, '%')) or " +
            "upper(p.productName) like upper(concat('%',:text,'%'))")
    List<ProductAdminResponse> search(@Param("text") String text, Pageable pageable);

    @Query("select count(p.id) from Product p where " +
            "cast(p.productVendorCode as string) like upper(concat(:text, '%')) or " +
            "upper(p.productName) like upper(concat('%',:text,'%'))")
    int searchCount(@Param("text") String text);

    @Query("select p.discount.amountOfDiscount from Product p where p.id = :id")
    int getAmountOfDiscount(Long id);

    @Query("select new com.example.gadgetariumb7.dto.response.ProductCardResponse (p.id, p.productImage, p.productName, " +
            "p.productCount, p.productPrice, p.productStatus, p.productRating) from Product p where p.id = :productId")
    ProductCardResponse convertToResponse(Long productId);

    @Query("select new com.example.gadgetariumb7.dto.response.ProductSearchResponse" +
            "(p.id," +
            "p.productImage," +
            "p.productName," +
            "p.productCount," +
            "p.productPrice," +
            "p.productStatus," +
            "p.productRating," +
            "p.brand.brandName," +
            "p.category.categoryName," +
            "p.subCategory.subCategoryName," +
            "p.discount.amountOfDiscount," +
            "p.description," +
            "p.productVendorCode," +
            "p.color," +
            "p.category.id" +
            ") from Product p where " +
            "upper(p.productName) like upper(concat('%',:text,'%')) OR " +
            "cast(p.productPrice as string) like concat(:text,'%') OR " +
            "cast(p.productRating as string) like :text OR " +
            "upper(p.category.categoryName) like upper(concat ('%',:text,'%')) OR " +
            "upper(p.brand.brandName) like upper(concat('%',:text, '%')) OR " +
            "upper(p.subCategory.subCategoryName) like upper(concat('%', :text, '%')) OR " +
            "cast(concat(p.discount.amountOfDiscount,'%') as string) like :text OR " +
            "cast(p.productVendorCode as string) like upper(concat(:text, '%')) OR " +
            "upper(p.color) like upper(concat('%',:text,'%')) ")
    List<ProductSearchResponse> searchCatalog(@Param("text") String text, Pageable pageable);

    @Query(nativeQuery = true, value = "select viewed_products_list_id from users_viewed_products_list where user_id = :userId")
    List<Long> getViewedProducts(Long userId);

    @Query(nativeQuery = true, value = "select count(o) from users_compare_products_list p, products o where o.id = p.compare_products_list_id and p.user_id = :id and o.category_id = :categoryId")
    int countCompare(Long id, Long categoryId);

    @Query("select u.compareProductsList as p from User u where u.id = :userId")
    List<Product> getAllFromUserCompareProductList(Long userId, Pageable pageable);

    @Query("select id from Product where category.id = :categoryId")
    List<Long> getCategoryProducts(Long categoryId);
}