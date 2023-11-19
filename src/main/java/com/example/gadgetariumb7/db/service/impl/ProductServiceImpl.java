package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.entity.*;
import com.example.gadgetariumb7.db.enums.ProductStatus;
import com.example.gadgetariumb7.db.repository.*;
import com.example.gadgetariumb7.db.service.ProductService;
import com.example.gadgetariumb7.dto.converter.ColorNameMapper;
import com.example.gadgetariumb7.dto.response.InforgraphicsResponse;
import com.example.gadgetariumb7.dto.request.ProductRequest;
import com.example.gadgetariumb7.dto.request.ProductUpdateRequest;
import com.example.gadgetariumb7.dto.request.SubproductUpdateRequest;
import com.example.gadgetariumb7.dto.response.*;
import com.example.gadgetariumb7.exceptions.BadRequestException;
import com.example.gadgetariumb7.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AopInvocationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final SubproductRepository subproductRepository;
    private final ColorNameMapper colorNameMapper;

    private User getAuthenticateUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        log.info("the token has taken successfully");
        return userRepository.findByEmail(login).orElseThrow(() -> {
            log.error("User not found");
            return new NotFoundException("User not found!");
        });
    }

    private Optional<User> getAuthenticateUserForFavorite() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        log.info("The user token for favorite has taken");
        return userRepository.findByEmail(login);
    }

    @Override
    public List<ProductCardResponse> getAllDiscountProductToMP(int page, int size) {
        List<ProductCardResponse> discountProducts = productRepository.getAllDiscountProduct(PageRequest.of(page - 1, size));
        discountProducts.forEach(p -> {
            p.setFirstSubproductId(getSubProductsId(p.getProductId()));
            p.setCategoryId(productRepository.findById(p.getProductId()).orElseThrow(() -> new NotFoundException("Product not found")).getCategory().getId().byteValue());
        });
        log.info("all discount product taken to main page successfully");
        return checkFavorite(discountProducts);
    }

    @Override
    public List<ProductCardResponse> getAllNewProductToMP(int page, int size) {
        List<ProductCardResponse> newProducts = productRepository.getAllNewProduct(PageRequest.of(page - 1, size));
        newProducts.forEach(p -> {
            p.setFirstSubproductId(getSubProductsId(p.getProductId()));
            p.setCategoryId(productRepository.findById(p.getProductId()).orElseThrow(() -> new NotFoundException("Product not found")).getCategory().getId().byteValue());
        });
        log.info("all new product taken to main page successfully");
        return checkFavorite(newProducts);
    }

    @Override
    public List<ProductCardResponse> getAllRecommendationProductToMP(int page, int size) {
        List<ProductCardResponse> recommendations = productRepository.getAllRecommendationProduct(PageRequest.of(page - 1, size));
        recommendations.forEach(p -> {
            p.setFirstSubproductId(getSubProductsId(p.getProductId()));
            p.setCategoryId(productRepository.findById(p.getProductId()).orElseThrow(() -> new NotFoundException("Product not found")).getCategory().getId().byteValue());
        });
        log.info("all recommendation product taken to main page successfully");
        return checkFavorite(recommendations);
    }

    private List<ProductCardResponse> checkFavorite(List<ProductCardResponse> productCardResponses) {
        productCardResponses.forEach(r -> {
            r.setFirstSubproductId(getSubProductsId(r.getProductId()));
            setDiscountToResponse(r, null);
            r.setCountOfReview(productRepository.getAmountOfFeedback(r.getProductId()));
        });
        if (getAuthenticateUserForFavorite().isPresent()) {
            User user = getAuthenticateUserForFavorite().get();
            productCardResponses.forEach(x -> {
                Optional<Product> productOptional = productRepository.findById(x.getProductId());
                if (productOptional.isPresent()) {
                    if (user.getFavoritesList().contains(productOptional.get())) {
                        x.setFavorite(true);
                    }
                    if (user.getCompareProductsList().contains(productOptional.get())) {
                        x.setCompared(true);
                    }
                } else {
                    log.error("Product not found");
                    throw new NotFoundException("Product not found!");
                }
            });
        }
        log.info("favorite has checked successfully");
        return productCardResponses;
    }

    @Override
    public ProductAdminPaginationResponse getProductAdminResponses(String searchText, String productType, String fieldToSort, String discountField, LocalDate startDate, LocalDate endDate, int page, int size) {
        ProductAdminPaginationResponse productAdminPaginationResponse = new ProductAdminPaginationResponse();
        List<ProductAdminResponse> productAdminResponses;

        if (searchText == null) {
            // sort product by the parameters
            productAdminResponses = sortingProduct(fieldToSort, discountField, productRepository.getAllProductsAdmin(PageRequest.of(page - 1, size)), startDate, endDate);
            productAdminPaginationResponse.setResponseList(productAdminResponses);

            // set pagination to response
            if (productRepository.getCountOfProducts() % size == 0) {
                productAdminPaginationResponse.setPages(productRepository.getCountOfProducts() / size);
            } else {
                productAdminPaginationResponse.setPages((productRepository.getCountOfProducts() / size) + 1);
            }
            productAdminPaginationResponse.setCurrentPage(page);
        } else {
            productAdminResponses = sortingProduct(fieldToSort, discountField, productRepository.search(searchText, PageRequest.of(page - 1, size)), startDate, endDate);
            productAdminPaginationResponse.setResponseList(productAdminResponses);

            // get count of product with search by text
            if (productRepository.searchCount(searchText) % size == 0) {
                productAdminPaginationResponse.setPages(productRepository.searchCount(searchText) / size);
            } else {
                productAdminPaginationResponse.setPages((productRepository.searchCount(searchText) / size) + 1);
            }
            productAdminPaginationResponse.setCurrentPage(page);
        }
        if (productType != null) {
            // check and filter by type of product from request
            switch (productType) {
                case "Все товары" -> {
                    productAdminPaginationResponse.setResponseList(productAdminResponses);
                    return productAdminPaginationResponse;
                }
                case "В продаже" -> {
                    // filter only which have count of product than > 0
                    productAdminResponses = productAdminResponses.stream().filter(x -> x.getProductCount() > 0).toList();
                    productAdminPaginationResponse.setResponseList(productAdminResponses);
                    return productAdminPaginationResponse;
                }
                case "В корзине" -> {
                    List<Product> productList = new ArrayList<>();
                    List<ProductAdminResponse> responseList = new ArrayList<>();

                    // get product from users bucket list
                    userRepository.findAll().stream().filter(u -> u.getBasketList() != null).forEach(x -> x.getBasketList().keySet().stream().map(Subproduct::getProduct).filter(product -> !productList.contains(product)).forEach(productList::add));
                    return getProductAdminPaginationResponse(fieldToSort, discountField, startDate, endDate, productAdminPaginationResponse, productList, responseList);
                }
                case "В избранном" -> {
                    List<Product> productList = new ArrayList<>();
                    List<ProductAdminResponse> responseList = new ArrayList<>();

                    // get product from user favorites list
                    userRepository.findAll().stream().filter(u -> u.getFavoritesList() != null).forEach(x -> x.getFavoritesList().stream().filter(p -> !productList.contains(p)).forEach(productList::add));
                    return getProductAdminPaginationResponse(fieldToSort, discountField, startDate, endDate, productAdminPaginationResponse, productList, responseList);
                }
                default -> {
                    log.error("Product type is not correct");
                    throw new BadRequestException("Product type is not correct");
                }
            }
        }
        log.info("admin product is delivered");
        return productAdminPaginationResponse;
    }

    private ProductAdminPaginationResponse getProductAdminPaginationResponse(String fieldToSort, String discountField, LocalDate startDate, LocalDate endDate, ProductAdminPaginationResponse productAdminPaginationResponse, List<Product> productList, List<ProductAdminResponse> responseList) {
        List<ProductAdminResponse> productAdminResponses;
        productList.forEach(p -> responseList.add(new ProductAdminResponse(p.getId(), p.getProductImage(), p.getProductVendorCode(), p.getProductName(), p.getProductCount(), p.getSubproducts().size(), p.getCreateAt(), p.getProductPrice(), p.getProductStatus())));
        productAdminResponses = sortingProduct(fieldToSort, discountField, responseList, startDate, endDate);
        productAdminPaginationResponse.setResponseList(productAdminResponses);
        return productAdminPaginationResponse;
    }

    @Override
    public SimpleResponse delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            log.error("Product for delete not found");
            return new NotFoundException("Product for delete not found!");
        });
        userRepository.findAll().forEach(x -> {
            if (x.getFavoritesList() != null) {
                x.getFavoritesList().remove(product);
            }
            product.getSubproducts().forEach(i -> x.getBasketList().remove(i));
            if (x.getCompareProductsList() != null) {
                x.getCompareProductsList().remove(product);
            }
            if (x.getViewedProductsList() != null) {
                x.getViewedProductsList().remove(product);
            }
            if (x.getOrderHistoryList() != null) {
                x.getOrderHistoryList().remove(product);
            }
            userRepository.save(x);
        });
        productRepository.delete(product);
        log.info("successfully works the delete method");
        return new SimpleResponse("Product successfully deleted!", "ok");
    }

    @Override
    public SimpleResponse update(ProductUpdateRequest productUpdateRequest) {
        Product product = productRepository.findById(productUpdateRequest.getId()).orElseThrow(() -> {
            log.error("Product for update not found");
            return new NotFoundException("Product for update not found!");
        });
        List<Subproduct> subProducts = product.getSubproducts();
        List<SubproductUpdateRequest> subProductUpdateRequests = new ArrayList<>(productUpdateRequest.getSubproductUpdateRequests());
        for (SubproductUpdateRequest s : subProductUpdateRequests) {
            Subproduct subproduct = subproductRepository.findById(s.getId()).orElseThrow(() -> {
                log.error("SubProduct for update not found!");
                return new NotFoundException("SubProduct for update not found!");
            });
            int index = subProducts.indexOf(subproduct);
            if (index != -1) {
                if (s.getSubproductCount() != 0) subproduct.setCountOfSubproduct(s.getSubproductCount());
                if (s.getPrice() != 0) subproduct.setPrice(s.getPrice());
                subProducts.set(index, subproduct);
            }

            if (index == 0) {
                product.setProductPrice(subproduct.getPrice());
                product.setProductCount(subproduct.getCountOfSubproduct());
            }
        }
        product.setSubproducts(subProducts);
        productRepository.save(product);
        log.info("successfully works the update method");
        return new SimpleResponse("Product successfully updated", "ok");
    }

    private List<ProductAdminResponse> sortingProduct(String fieldToSort, String discountField, List<ProductAdminResponse> products, LocalDate startDate, LocalDate endDate) {
        products.forEach(r -> setDiscountToResponse(null, r));
        if (fieldToSort != null) {
            switch (fieldToSort) {
                case "Новинки" ->
                        products = products.stream().filter(x -> x.getProductStatus() == ProductStatus.NEW).toList();
                case "По акции" -> {
                    if (discountField != null) {
                        switch (discountField) {
                            case "Все акции" ->
                                    products = products.stream().filter(x -> x.getAmountOfDiscount() > 0).toList();
                            case "До 50%" ->
                                    products = products.stream().filter(x -> x.getAmountOfDiscount() < 50 && x.getAmountOfDiscount() > 0).toList();
                            case "Свыше 50%" ->
                                    products = products.stream().filter(x -> x.getAmountOfDiscount() > 50).toList();
                            default -> throw new BadRequestException("Discount sort field is not correct");
                        }
                    }
                }
                case "Рекомендуемые" ->
                        products = products.stream().filter(x -> x.getProductStatus() == ProductStatus.RECOMMENDATION).toList();
                case "По увеличению цены" -> products.sort(Comparator.comparing(ProductAdminResponse::getProductPrice));
                case "По уменьшению цены" ->
                        products.sort(Comparator.comparing(ProductAdminResponse::getProductPrice).reversed());
                default -> {
                    log.error("Sort field is not correct");
                    throw new BadRequestException("Sort field is not correct");
                }
            }
        }
        if (startDate != null && endDate != null)
            return products.stream().filter(p -> p.getCreateAt().toLocalDate().isAfter(startDate) && p.getCreateAt().toLocalDate().isBefore(endDate)).toList();
        log.info("successfully works the sorting product method");
        return products;
    }


    private void setDiscountToResponse(ProductCardResponse productCardResponse, ProductAdminResponse productAdminResponse) {
        try {
            if (productCardResponse != null) {
                if (productRepository.getDiscountPrice(productCardResponse.getProductId()) == 0) {
                    productCardResponse.setDiscountPrice(productCardResponse.getProductPrice());
                } else {
                    productCardResponse.setDiscountPrice(Math.round((float) productRepository.getDiscountPrice(productCardResponse.getProductId())));
                }
            } else if (productAdminResponse != null) {
                if (productRepository.getDiscountPrice(productAdminResponse.getId()) == 0) {
                    productAdminResponse.setAmountOfDiscount(productAdminResponse.getAmountOfDiscount());
                } else {
                    productAdminResponse.setAmountOfDiscount(productRepository.getAmountOfDiscount(productAdminResponse.getId()));
                    productAdminResponse.setCurrentPrice(productRepository.getDiscountPrice(productAdminResponse.getId()));
                }
            }
        } catch (RuntimeException e) {
            log.error("null discount");
        }
        log.info("successfully works the setDiscountResponse");
    }

    @Override
    public SimpleResponse addProduct(ProductRequest productRequest) {
        Brand brand = brandRepository.findById(productRequest.getBrandId()).orElseThrow(() -> {
            log.error("Brand not found");
            return new NotFoundException("Brand not found");
        });
        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> {
            log.error("Category not found");
            return new NotFoundException("Category not found");
        });
        Subcategory subcategory = subcategoryRepository.findById(productRequest.getSubCategoryId()).orElseThrow(() -> {
            log.error("Subcategory not found");
            return new NotFoundException("Subcategory not found");
        });
        List<Subproduct> subProducts = new ArrayList<>();
        productRequest.getSubProductRequests().forEach(x -> subProducts.add(new Subproduct(x)));

        Product product = new Product(productRequest, subProducts, brand, category, subcategory);
        product.setCreateAt(LocalDateTime.now());
        product.setProductStatus(ProductStatus.NEW);
        product.setSubproducts(subProducts);
        product.setProductRating(0.0);
        product.setDateOfIssue(productRequest.getDateOfIssue());
        subProducts.forEach(s -> s.setProduct(product));
        productRepository.save(product);
        log.info("successfully works the add product method");
        return new SimpleResponse("Product successfully saved", "ok");
    }

    @Override
    public List<ColorResponse> colorCount(Long categoryId) {
        List<Long> productsId = productRepository.getCategoryProducts(categoryId);
        List<ColorResponse> colorResponses = new ArrayList<>();
        for (Long x : productsId) {
            Product product = productRepository.findById(x).orElseThrow(() -> new NotFoundException("Product not found"));
            if (colorResponses.isEmpty() || colorResponses.stream().noneMatch(c -> c.getColorName().equalsIgnoreCase(colorNameMapper.getColorName(product.getColor())))) {
                colorResponses.add(new ColorResponse(product.getColor(), colorNameMapper.getColorName(product.getColor()), (int) productsId.stream().filter(p -> productRepository.findById(p).orElseThrow(() -> new NotFoundException("Product not found")).getColor().equals(product.getColor())).count()));
            }
        }
        return colorResponses;
    }

    @Override
    public List<ProductCardResponse> getViewedProducts() {
        List<Long> productsId = productRepository.getViewedProducts(getAuthenticateUser().getId());
        List<ProductCardResponse> responses = new ArrayList<>();
        productsId.forEach(r -> {
            Product p = productRepository.findById(r).orElseThrow(() -> {
                log.error("Product not found");
                return new NotFoundException("Product not found");
            });
            responses.add(new ProductCardResponse(p.getId(), p.getProductName(), p.getProductImage(), p.getProductRating(),
                    productRepository.getAmountOfFeedback(p.getId()), p.getProductPrice()));
        });
        responses.forEach(p -> p.setCategoryId(productRepository.findById(p.getProductId()).orElseThrow(() -> new NotFoundException("Product not found")).getCategory().getId().byteValue()));
        log.info("successfully works the getViewedProducts");
        return responses;

    }

    @Override
    public InforgraphicsResponse infographics() throws NullPointerException {
        try {
            InforgraphicsResponse infographics = new InforgraphicsResponse();
            infographics.setSoldCount(productRepository.getCountSoldProducts());
            infographics.setSoldPrice(productRepository.getSoldProductPrice());
            infographics.setOrderCount(productRepository.getCountOrderProduct());
            infographics.setOrderPrice(productRepository.getOrderProductPrice());
            infographics.setCurrentPeriodPerDay(productRepository.getCurrentPeriodPerDay());
            infographics.setCurrentPeriodPerMonth(productRepository.getCurrentPeriodPerMonth());
            infographics.setCurrentPeriodPerYear(productRepository.getCurrentPeriodPerYear());
            infographics.setPreviousPeriodPerDay(productRepository.getPreviousPeriodPerDay());
            infographics.setPreviousPeriodPerMonth(productRepository.getPreviousPeriodPerMonth());
            infographics.setPreviousPeriodPerYear(productRepository.getPreviousPeriodPerYear());
            log.info("successfully works the infographics method");
            return infographics;
        } catch (AopInvocationException e) {
            log.error("Infographic is null");
            throw new BadRequestException("Infographic is null");
        }
    }

    @Override
    public ProductSingleResponse getProductById(Long productId, String attribute, Integer size) {
        User user = getAuthenticateUser();

        ProductSingleResponse productSingleResponse;

        Product p = productRepository.findById(productId).orElseThrow(() -> {
            log.error("We don't have the product with such id");
            return new NotFoundException("we don't have the product with such id");
        });

        List<SubproductResponse> subProducts = p.getSubproducts().stream().map(s -> new SubproductResponse(s.getId(), s.getCountOfSubproduct(),
                s.getImages(), s.getPrice(), colorNameMapper.getColorName(s.getColor()), s.getColor(), s.getCharacteristics())).toList();
        productSingleResponse = new ProductSingleResponse(p.getId(), p.getProductName(), p.getProductCount(),
                p.getProductVendorCode(), p.getCategory().getCategoryName(), p.getSubCategory().getSubCategoryName(),
                p.getUsersReviews().size(), p.getProductPrice(), p.getProductRating(), subProducts);

        try {
            productSingleResponse.setAmountOfDiscount(p.getDiscount().getAmountOfDiscount());
        } catch (RuntimeException e) {
            log.error("null discount");
        }
        if (user.getFavoritesList().contains(p)) {
            productSingleResponse.setFavorite(true);
        }
        switch (attribute) {
            case "Описание" -> {
                String description = p.getDescription();
                productSingleResponse.setAttribute("Описание", description);
                productSingleResponse.setVideoReview(p.getVideoReview());
            }
            case "Характеристики" -> {
                Map<String, String> characteristics = p.getSubproducts().get(0).getCharacteristics();
                productSingleResponse.setAttribute("Характеристики", characteristics);
            }
            case "Отзывы" -> {
                List<Review> reviews = p.getUsersReviews();
                List<ReviewMainResponse> reviewMainResponses = reviews.stream().map(r -> new ReviewMainResponse(
                        r.getId(), r.getUserReview(), r.getResponseOfReview(),
                        r.getReviewTime(), r.getProductGrade(), new UserMainResponse(
                        r.getUser().getId(), r.getUser().getFirstName() + " " + r.getUser().getLastName(),
                        r.getUser().getImage())
                )).toList();

                for (ReviewMainResponse review : reviewMainResponses) {
                    if (review.getUserMainResponse().getId().equals(user.getId()))
                        review.setMyReview(true);
                }

                if (size == null) {
                    size = 3;
                }

                int toIndex = Math.min(size, reviewMainResponses.size());
                reviewMainResponses = reviewMainResponses.subList(0, toIndex);
                Map<Integer, Integer> counts = new HashMap<>();
                for (int i = 1; i < 6; i++) {
                    counts.put(i, reviewRepository.getCountReviewOfProduct(productSingleResponse.getId(), i));
                }
                productSingleResponse.setReviewCount(counts);
                productSingleResponse.setAttribute("Отзывы", reviewMainResponses);
            }
        }

        // adding to user history
        user.addViewedProduct(p);

        // add status reviewed
        if (user.getUserReviews().stream().anyMatch(x -> Objects.equals(x.getProduct().getId(), p.getId())))
            productSingleResponse.setReviewed(true);

        userRepository.save(user);

        log.info("successfully works the productSingleResponse method");
        return productSingleResponse;
    }

    private List<Long> getSubProductsId(Long id) {
        return subproductRepository.findAll().stream().filter(x -> Objects.equals(x.getProduct().getId(), id)).map(Subproduct::getId).toList();
    }
}