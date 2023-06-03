package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.CartRequestDto;
import com.example.ecommerce.dto.response.CartResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;

import java.util.List;

public interface CartService {
    ResponseDto save(CartRequestDto cartRequestDto);
    List<CartResponseDto> getAllCarts();
    ResponseDto deleteCart(CartRequestDto cartRequestDto);
}
