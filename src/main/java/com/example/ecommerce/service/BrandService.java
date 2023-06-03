package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.BrandRequestDto;
import com.example.ecommerce.dto.response.BrandResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;

import java.util.List;

public interface BrandService {
    ResponseDto save(BrandRequestDto brandRequestDto,Long cat_id);
    List<BrandResponseDto> getAllBrands(Long cat_id);
    BrandResponseDto getBrandById(Long id);
}
