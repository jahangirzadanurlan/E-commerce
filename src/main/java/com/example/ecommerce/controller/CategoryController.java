package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.BrandRequestDto;
import com.example.ecommerce.dto.request.CategoryRequestDto;
import com.example.ecommerce.dto.request.ProductRequestDto;
import com.example.ecommerce.dto.response.BrandResponseDto;
import com.example.ecommerce.dto.response.CategoryResponseDto;
import com.example.ecommerce.dto.response.ProductResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;
import com.example.ecommerce.service.BrandService;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final ProductService productService;


    @GetMapping
    public List<CategoryResponseDto> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @PostMapping
    public ResponseDto saveCategory(@RequestBody CategoryRequestDto category){
        return categoryService.save(category);
    }
    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
    @PutMapping
    public ResponseDto updateCategory(@RequestBody CategoryRequestDto category){
        return categoryService.save(category);
    }

    @GetMapping("/{id}/brand")
    public List<BrandResponseDto> getAllBrands(@PathVariable Long id){
        return brandService.getAllBrands(id);
    }
    @PostMapping("{id}/brand")
    public ResponseDto saveBrand(@RequestBody BrandRequestDto brand,@PathVariable Long id){
        return brandService.save(brand,id);
    }
    @GetMapping("/brand/{id}")
    public BrandResponseDto getBrandById( @PathVariable Long id){
        return brandService.getBrandById(id);
    }
    @PutMapping("/{id}/brand")
    public ResponseDto updateBrand(@RequestBody BrandRequestDto brand,@PathVariable Long id){
        return brandService.save(brand,id);
    }

    @GetMapping("/{cat_id}/brand/{br_id}/product")
    public List<ProductResponseDto> getAllProduct(@PathVariable Long br_id){
        return productService.getAllProducts(br_id);
    }
    @PostMapping("/{cat_id}/brand/{br_id}/product")
    public ResponseDto saveProduct(@RequestBody ProductRequestDto product,@PathVariable Long br_id){
        return productService.save(product,br_id);
    }
    @GetMapping("/{cat_id}/brand/{br_id}/product/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PutMapping("/{cat_id}/brand/{br_id}/product")
    public ResponseDto updateProduct(@RequestBody ProductRequestDto product,@PathVariable Long br_id){
        return productService.save(product,br_id);
    }


}
