package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.CategoryRequestDto;
import com.example.ecommerce.dto.response.CategoryResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;

import java.util.List;

public interface CategoryService {
    ResponseDto save(CategoryRequestDto categoryRequestDto);
    List<CategoryResponseDto> getAllCategory();
    CategoryResponseDto getCategoryById(Long id);
}
