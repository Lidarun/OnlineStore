package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.entity.*;
import com.example.gadgetariumb7.db.repository.*;
import com.example.gadgetariumb7.dto.request.ProductRequest;
import com.example.gadgetariumb7.dto.request.SubProductRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private SubcategoryRepository subcategoryRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void addProduct() {
        ProductRequest request = new ProductRequest();
        request.setBrandId(1L);
        request.setCategoryId(2L);
        request.setSubCategoryId(3L);
        request.setDateOfIssue("2022-03-11");
        request.setProductName("Test Product");
        request.setProductVendorCode(123456L);
        request.setGuarantee((byte) 2);
        request.setVideoReview("testReviewLink");
        request.setPDF("testPDF");
        request.setDescription("This is a test product");

        List<SubProductRequest> subProducts = new ArrayList<>();
        SubProductRequest subProduct = new SubProductRequest();
        subProduct.setPrice(10);
        subProduct.setCountOfProduct(100);
        subProduct.setColor("Red");
        subProduct.setImages(Collections.singletonList("testImage"));
        subProduct.setCharacteristics(Collections.singletonMap("Size", "Small"));
        subProducts.add(subProduct);
        request.setSubProductRequests(subProducts);

        Brand brand = new Brand();
        brand.setId(1L);
        when(brandRepository.findById(anyLong())).thenReturn(java.util.Optional.of(brand));

        Category category = new Category();
        category.setId(2L);
        when(categoryRepository.findById(anyLong())).thenReturn(java.util.Optional.of(category));

        Subcategory subcategory = new Subcategory();
        subcategory.setId(3L);
        when(subcategoryRepository.findById(anyLong())).thenReturn(java.util.Optional.of(subcategory));

        when(productRepository.save(any())).thenReturn(new Product());

        SimpleResponse response = productService.addProduct(request);

        assertThat(response.getMessage()).isEqualTo("Product successfully saved");
        assertThat(response.getStatus()).isEqualTo("ok");
    }
}