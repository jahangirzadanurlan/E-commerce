package com.example.ecommerce.exception;

import com.example.ecommerce.enums.ExceptionEnum;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
        super(ExceptionEnum.CATEGORY_NOT_FOUND_EXCEPTION.getMessage());
    }

}
