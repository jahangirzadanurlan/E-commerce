package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.ProductRequestDto;
import com.example.ecommerce.dto.response.ProductResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;

import java.util.List;

public interface ProductService {
    ResponseDto save(ProductRequestDto productRequestDto,Long br_id);
    List<ProductResponseDto> getAllProducts(Long br_id);
    ProductResponseDto getProductById(Long id);
}
