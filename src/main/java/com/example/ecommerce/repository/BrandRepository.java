package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand getBrandById(Long id);
}
