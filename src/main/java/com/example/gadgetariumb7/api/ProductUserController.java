package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.FilterProductsService;
import com.example.gadgetariumb7.db.service.ProductService;
import com.example.gadgetariumb7.dto.response.CatalogResponse;
import com.example.gadgetariumb7.dto.response.ColorResponse;
import com.example.gadgetariumb7.dto.response.ProductCardResponse;
import com.example.gadgetariumb7.dto.response.ProductSingleResponse;
import com.example.gadgetariumb7.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Product API")
public class ProductUserController {

    private final ProductService productService;
    private final FilterProductsService filterProductsService;

    @Operation(summary = "Get all products with discount to main page", description = "This endpoint return ProductResponse with discounts")
    @GetMapping("/discounts")
    public List<ProductCardResponse> getAllDiscountProductMainPage(@RequestParam int page, @RequestParam int size) {
        return productService.getAllDiscountProductToMP(page, size);
    }

    @Operation(summary = "Get all products with new status to main page", description = "This endpoint return ProductResponse with new status")
    @GetMapping("/newProducts")
    public List<ProductCardResponse> getAllNewProductMainPage(@RequestParam int page, @RequestParam int size) {
        return productService.getAllNewProductToMP(page, size);
    }

    @Operation(summary = "Get all products with recommendation status to main page", description = "This endpoint return ProductResponse with recommendation status")
    @GetMapping("/recommendations")
    public List<ProductCardResponse> getAllRecommendationProductMainPage(@RequestParam int page, @RequestParam int size) {
        return productService.getAllRecommendationProductToMP(page, size);
    }

    @Operation(summary = "Get products from catalog", description = "The user can filter by several parameters and categoryName is always required in filtering, but others no because user shouldn't give them all." +
            "The field 'fieldToSort' is using if the user wants to sort the products by next fields: Новинки, По акции(if you choose this field you need to write also to discountField one of next three: Все акции, До 50%, Свыше 50%), Рекомендуемые, По увеличению цены, По уменьшению цены.'" +
            "Also if the 'text' is null will work only the filter and sort, but if you write something int text then will work only searching. Required only the size")
    @GetMapping("/catalog")
    @PreAuthorize("isAuthenticated()")
    public CatalogResponse filterByParameters(@RequestParam(required = false) String fieldToSort, @RequestParam(required = false) String discountField, @RequestParam(required = false) String categoryName, @RequestParam(required = false) List<String> subCategoryNames, @RequestParam(required = false) Integer minPrice, @RequestParam(required = false) Integer maxPrice, @RequestParam(required = false) List<String> colors,
                                              @RequestParam(required = false) List<Integer> memories, @RequestParam(required = false) List<Byte> rams, @RequestParam(required = false) List<String> laptopCPUs, @RequestParam(required = false) List<String> screenResolutions, @RequestParam(required = false) List<String> screenSizes, @RequestParam(required = false) List<String> screenDiagonals, @RequestParam(required = false) List<String> batteryCapacities,
                                              @RequestParam(required = false) List<String> wirelessInterfaces, @RequestParam(required = false) List<String> caseShapes, @RequestParam(required = false) List<String> braceletMaterials, @RequestParam(required = false) List<String> housingMaterials, @RequestParam(required = false) List<String> genders, @RequestParam(required = false) List<String> waterProofs, @RequestParam() int size) throws NotFoundException {
        return filterProductsService.filterByParameters(fieldToSort, discountField, categoryName, subCategoryNames, minPrice, maxPrice, colors,
                memories, rams, laptopCPUs, screenResolutions, screenSizes, screenDiagonals, batteryCapacities,
                wirelessInterfaces, caseShapes, braceletMaterials, housingMaterials, genders, waterProofs, size);
    }

    @Operation(summary = "Get products from catalog with search")
    @GetMapping("/catalog/search")
    @PreAuthorize("isAuthenticated()")
    public CatalogResponse filterByParameters(@RequestParam(required = false) String searchText, @RequestParam() int size) throws NotFoundException {
        return filterProductsService.filterByParameters(searchText, size);
    }


    @Operation(summary = "Get last viewed products", description = "This method shows last viewed products")
    @GetMapping("/viewed")
    @PreAuthorize("isAuthenticated()")
    public List<ProductCardResponse> getViewedProducts() {
        return productService.getViewedProducts();
    }

    @Operation(summary = "Get product by id", description = "to get the inner page of product you always need to give the id of product and by default the attribute 'Описание'" +
            "size is required if you need attribute 'Отзывы'")
    @GetMapping("/product")
    @PreAuthorize("isAuthenticated()")
    public ProductSingleResponse getProductById(@RequestParam(value = "id") Long productId, @RequestParam String attribute, @RequestParam(required = false) Integer size) throws NotFoundException {
        return productService.getProductById(productId, attribute, size);
    }

    @Operation(summary = "Get category colors", description = "This method for get colors count from category response")
    @GetMapping("/getColors")
    @PreAuthorize("isAuthenticated()")
    public List<ColorResponse> getColorsFromCategory(@RequestParam Long categoryId) {
        return productService.colorCount(categoryId);
    }
}