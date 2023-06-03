package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.request.CategoryRequestDto;
import com.example.ecommerce.dto.response.CategoryResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;


    @Override
    public ResponseDto save(CategoryRequestDto categoryRequestDto) {
        Category category=categoryRepository.save(modelMapper.map(categoryRequestDto, Category.class));
        Category category1=new Category();
        return category!=null ? new ResponseDto("Category Created Successfully!"):
                new ResponseDto("Category Created unsuccessfully!!!");
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category,CategoryResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        return modelMapper.map(categoryRepository.findCategoryById(id),CategoryResponseDto.class);
    }
}
