package com.example.ecommerce.repository;

import com.example.ecommerce.dto.response.CategoryResponseDto;
import com.example.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findCategoryById(Long id);
}
