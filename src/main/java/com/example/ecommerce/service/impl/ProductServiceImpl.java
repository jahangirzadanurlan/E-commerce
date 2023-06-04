package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.request.ProductRequestDto;
import com.example.ecommerce.dto.response.ProductResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;
import com.example.ecommerce.entity.Brand;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.BrandNotFoundException;
import com.example.ecommerce.repository.BrandRepository;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Override
    public ResponseDto save(ProductRequestDto productRequestDto,Long br_id) {
        Product product=modelMapper.map(productRequestDto,Product.class);
        Brand brand=brandRepository.getBrandById(br_id);
        if (brand!=null){
            product.setBrand(brand);
            productRepository.save(product);
            return new ResponseDto("Save is successful!");
        } else {
            throw new BrandNotFoundException();
        }
    }

    @Override
    public List<ProductResponseDto> getAllProducts(Long br_id) {
        Brand brand=brandRepository.getBrandById(br_id);
        return brand.getProducts().stream()
                .map(product -> modelMapper.map(product,ProductResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return modelMapper.map(productRepository.findProductById(id),ProductResponseDto.class);
    }
}
