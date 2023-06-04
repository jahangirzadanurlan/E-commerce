package com.example.ecommerce.exception;

import com.example.ecommerce.enums.ExceptionEnum;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(){
        super(ExceptionEnum.BRAND_NOT_FOUND_EXCEPTION.getMessage());
    }
}
