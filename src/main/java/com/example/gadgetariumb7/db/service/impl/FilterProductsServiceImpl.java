package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.entity.Product;
import com.example.gadgetariumb7.db.entity.Subproduct;
import com.example.gadgetariumb7.db.entity.User;
import com.example.gadgetariumb7.db.enums.ProductStatus;
import com.example.gadgetariumb7.db.repository.ProductRepository;
import com.example.gadgetariumb7.db.repository.SubproductRepository;
import com.example.gadgetariumb7.db.repository.UserRepository;
import com.example.gadgetariumb7.db.service.FilterProductsService;
import com.example.gadgetariumb7.dto.response.CatalogResponse;
import com.example.gadgetariumb7.dto.response.ProductAdminResponse;
import com.example.gadgetariumb7.dto.response.ProductCardResponse;
import com.example.gadgetariumb7.exceptions.BadRequestException;
import com.example.gadgetariumb7.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterProductsServiceImpl implements FilterProductsService {
    private final ProductRepository productRepository;
    private final SubproductRepository subproductRepository;
    private final UserRepository userRepository;

    private User getAuthenticateUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        return userRepository.findByEmail(login).orElseThrow(() -> {
            return new NotFoundException("User not found!");
        });
    }

    @Override
    public CatalogResponse filterByParameters(String fieldToSort, String discountField, String categoryName, List<String> subCategoryNames, Integer minPrice, Integer maxPrice, List<String> colors,
                                              List<Integer> memories, List<Byte> rams, List<String> laptopCPUs, List<String> screenResolutions, List<String> screenSizes, List<String> screenDiagonals, List<String> batteryCapacities,
                                              List<String> wirelessInterfaces, List<String> caseShapes, List<String> braceletMaterials, List<String> housingMaterials, List<String> genders, List<String> waterProofs, int size) throws NotFoundException {
        try {
            CatalogResponse catalogResponse = new CatalogResponse();

            List<Product> productList = productRepository.findAll();
            List<ProductCardResponse> productCardResponses = productList.stream()
                    .filter(p -> categoryName == null || p.getCategory().getCategoryName().equalsIgnoreCase(categoryName))
                    .filter(p -> subCategoryNames == null || subCategoryNames.isEmpty() || subCategoryNames.stream().map(String::toLowerCase).toList().contains(p.getSubCategory().getSubCategoryName().toLowerCase()))
                    .filter(p -> minPrice == null || p.getProductPrice() >= minPrice)
                    .filter(p -> maxPrice == null || p.getProductPrice() <= maxPrice)
                    .filter(p -> colors == null || colors.isEmpty() || colors.stream().map(String::toLowerCase).toList().contains(p.getColor().toLowerCase()))
                    .filter(p -> memories == null || memories.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Ноутбуки") && memories.stream().map(x -> x.toString().toLowerCase()).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("videoCardMemory").toLowerCase())) ||
                            (p.getCategory().getCategoryName().equalsIgnoreCase("Планшеты") && memories.stream().map(x -> x.toString().toLowerCase()).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("memoryOfTablet").toLowerCase())) ||
                            (p.getCategory().getCategoryName().equalsIgnoreCase("Смартфоны") && memories.stream().map(x -> x.toString().toLowerCase()).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("memoryOfPhone").toLowerCase())) ||
                            (p.getCategory().getCategoryName().equalsIgnoreCase("Смарт-часы и браслеты") && memories.stream().map(x -> x.toString().toLowerCase()).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("memoryOfSmartWatch").toLowerCase())))
                    .filter(p -> rams == null || rams.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Смартфоны") && rams.stream().map(x -> x.toString().toLowerCase()).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("ramOfPhone"))) ||
                            (p.getCategory().getCategoryName().equalsIgnoreCase("Ноутбуки") && rams.stream().map(x -> x.toString().toLowerCase()).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("ramLaptop").toLowerCase())) ||
                            (p.getCategory().getCategoryName().equalsIgnoreCase("Планшеты") && rams.stream().map(x -> x.toString().toLowerCase()).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("ramOfTablet").toLowerCase())))
                    .filter(p -> laptopCPUs == null || laptopCPUs.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Ноутбуки") &&
                            laptopCPUs.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("laptopCPU"))))
                    .filter(p -> screenResolutions == null || screenResolutions.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Ноутбуки") &&
                            screenResolutions.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("screenResolutionLaptop"))) ||
                            (p.getCategory().getCategoryName().equalsIgnoreCase("Планшеты") && screenResolutions.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("screenResolutionOfTablet").toLowerCase())))
                    .filter(p -> screenSizes == null || screenSizes.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Ноутбуки") &&
                            screenSizes.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("screenSizeLaptop"))) ||
                            (p.getCategory().getCategoryName().equalsIgnoreCase("Планшеты") && screenSizes.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("screenSizeOfTablet").toLowerCase())))
                    .filter(p -> screenDiagonals == null || screenDiagonals.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Планшеты") &&
                            screenDiagonals.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("screenDiagonalOfTablet"))) ||
                            (p.getCategory().getCategoryName().equalsIgnoreCase("Смарт-часы и браслеты") &&
                                    screenDiagonals.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("screenDiagonalOfSmartWatch").toLowerCase())))
                    .filter(p -> batteryCapacities == null || batteryCapacities.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Планшеты") &&
                            batteryCapacities.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("batteryCapacityOfTablet").toLowerCase())))
                    .filter(p -> wirelessInterfaces == null || wirelessInterfaces.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Смарт-часы и браслеты") &&
                            wirelessInterfaces.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("wirelessInterface").toLowerCase())))
                    .filter(p -> caseShapes == null || caseShapes.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Смарт-часы и браслеты") &&
                            caseShapes.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("caseShape").toLowerCase())))
                    .filter(p -> braceletMaterials == null || braceletMaterials.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Смарт-часы и браслеты") &&
                            braceletMaterials.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("braceletMaterial").toLowerCase())))
                    .filter(p -> housingMaterials == null || housingMaterials.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Смарт-часы и браслеты") &&
                            housingMaterials.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("housingMaterial").toLowerCase())))
                    .filter(p -> genders == null || genders.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Смарт-часы и браслеты") &&
                            genders.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("gender").toLowerCase())))
                    .filter(p -> waterProofs == null || waterProofs.isEmpty() || (p.getCategory().getCategoryName().equalsIgnoreCase("Смарт-часы и браслеты") &&
                            waterProofs.stream().map(String::toLowerCase).toList().contains(p.getSubproducts().get(0).getCharacteristics().get("waterProof").toLowerCase())))
                    .map(p -> new ProductCardResponse(p.getId(),
                            p.getProductImage(),
                            p.getProductName(),
                            p.getProductCount(),
                            p.getProductPrice(),
                            p.getProductStatus(),
                            p.getProductRating(),
                            p.getCategory().getId().byteValue()))
                    .collect(Collectors.toList());

            int toIndex = Math.min(size, productCardResponses.size());
            productCardResponses = productCardResponses.subList(0, toIndex);

            setStatusesToProducts(productCardResponses);

            if (fieldToSort != null) {
                productCardResponses = sortingProduct(fieldToSort, discountField, productCardResponses);
            }

            catalogResponse.setProductCardResponses(productCardResponses);
            catalogResponse.setSizeOfProducts(productCardResponses.size());
            return catalogResponse;
        } catch (NotFoundException | NullPointerException e) {
            throw new NotFoundException("Product not found");
        }
    }

    @Override
    public CatalogResponse filterByParameters(String text, int size) throws NotFoundException {
        if (text != null) {
            if (!text.isBlank()) {
                CatalogResponse catalogResponse = new CatalogResponse();
                List<ProductCardResponse> list = productRepository.searchCatalog(text, PageRequest.of(0, size)).stream()
                        .map(p -> new ProductCardResponse(p.getId(),
                                p.getProductImage(),
                                p.getProductName(),
                                p.getProductCount(),
                                p.getProductPrice(),
                                p.getProductStatus(),
                                p.getProductRating(),
                                p.getCategoryId().byteValue()))
                        .collect(Collectors.toList());
                setStatusesToProducts(list);

                catalogResponse.setProductCardResponses(list);
                catalogResponse.setSizeOfProducts(list.size());
                return catalogResponse;
            } else
                throw new BadRequestException("Search text is blank");
        } else
            throw new BadRequestException("Search text is null");
    }

    public void setStatusesToProducts(List<ProductCardResponse> productCardResponses) {
        for (ProductCardResponse productCardResponse : productCardResponses) {
            productCardResponse.setFirstSubproductId(getSubProductsId(productCardResponse.getProductId()));
            User user = getAuthenticateUser();
            Optional<Product> productOptional = productRepository.findById(productCardResponse.getProductId());
            if (productOptional.isPresent()) {
                if (user.getFavoritesList().contains(productOptional.get())) {
                    productCardResponse.setFavorite(true);
                }
                if (user.getCompareProductsList().contains(productOptional.get())) {
                    productCardResponse.setCompared(true);
                }
                Product product = productOptional.get();
                if (product.getUsersReviews() != null) {
                    int countFeedback = product.getUsersReviews().size();
                    productCardResponse.setCountOfReview(countFeedback);
                } else {
                    productCardResponse.setCountOfReview(0);
                }
                setDiscountToResponse(productCardResponse, null);
            } else {
                throw new NotFoundException();
            }
        }
    }

    private void setDiscountToResponse(ProductCardResponse productCardResponse, ProductAdminResponse productAdminResponse) {
        if (productCardResponse != null && productCardResponse.isCompared()) {
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
    }

    private List<Long> getSubProductsId(Long id) {
        return subproductRepository.findAll().stream().filter(x -> Objects.equals(x.getProduct().getId(), id)).map(Subproduct::getId).toList();
    }

    private List<ProductCardResponse> sortingProduct(String fieldToSort, String discountField, List<ProductCardResponse> productCardResponses) {
        if (fieldToSort != null) {
            switch (fieldToSort) {
                case "Новинки" ->
                        productCardResponses = productCardResponses.stream().filter(x -> x.getProductStatus() == ProductStatus.NEW).toList();
                case "По акции" -> {
                    if (discountField != null) {
                        switch (discountField) {
                            case "Все акции" ->
                                    productCardResponses = productCardResponses.stream().filter(x -> 100 - ((x.getDiscountPrice() * 100) / (x.getProductPrice())) > 0 && x.getDiscountPrice() != 0).toList();
                            case "До 50%" ->
                                    productCardResponses = productCardResponses.stream().filter(x -> (100 - (((x.getDiscountPrice()) * 100) / (x.getProductPrice()))) < 50 && (100 - ((x.getDiscountPrice() * 100) / (x.getProductPrice()))) > 0).toList();
                            case "Свыше 50%" ->
                                    productCardResponses = productCardResponses.stream().filter(x -> (100 - ((x.getDiscountPrice() * 100) / (x.getProductPrice()))) > 50 && x.getDiscountPrice() != 0).toList();
                        }
                    }
                }
                case "Рекомендуемые" ->
                        productCardResponses = productCardResponses.stream().filter(x -> x.getProductStatus() == ProductStatus.RECOMMENDATION).toList();
                case "По увеличению цены" ->
                        productCardResponses.sort(Comparator.comparing(ProductCardResponse::getProductPrice));
                case "По уменьшению цены" ->
                        productCardResponses.sort(Comparator.comparing(ProductCardResponse::getProductPrice).reversed());
            }
        }
        return productCardResponses;
    }
}