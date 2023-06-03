package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.request.BrandRequestDto;
import com.example.ecommerce.dto.response.BrandResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;
import com.example.ecommerce.entity.Brand;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repository.BrandRepository;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public ResponseDto save(BrandRequestDto brandRequestDto,Long cat_id) {
        Brand brand = modelMapper.map(brandRequestDto, Brand.class);
        Category category = categoryRepository.findById(cat_id).orElse(null);
        if (category != null) {
            brand.setCategory(category);
            brandRepository.save(brand);
            return new ResponseDto("Save is successful!");
        } else {
            return new ResponseDto("Invalid category_id!");
        }
    }

    @Override
    public List<BrandResponseDto> getAllBrands(Long cat_id) {
        Category category = categoryRepository.findById(cat_id).orElse(null);
        return category.getBrands().stream()
                .map(brand -> modelMapper.map(brand,BrandResponseDto.class))
                .collect(Collectors.toList());
        //Category id null gosterir
    }

    @Override
    public BrandResponseDto getBrandById(Long id) {
        return modelMapper.map(brandRepository.getBrandById(id),BrandResponseDto.class);
        //Category id null gosterir
    }
}
