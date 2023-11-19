package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.dto.request.ChangePasswordRequest;
import com.example.gadgetariumb7.dto.request.UserUpdateRequest;
import com.example.gadgetariumb7.dto.response.*;

import java.util.List;

public interface PersonalService {

    List<PersonalOrderResponse> getAllPersonalOrders();

    PersonalOrderByIdResponse getByIdPersonalOrder(Long orderId);

    List<ProductCardResponse> getAllPersonalFavorite();

    Object updateUser(UserUpdateRequest userUpdateRequest);

    PersonalUserResponse getPersonalUser();

    SimpleResponse clearOrdersHistory();

    SimpleResponse changePassword(ChangePasswordRequest request);

}