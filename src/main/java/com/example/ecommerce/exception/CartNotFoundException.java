package com.example.ecommerce.exception;

import com.example.ecommerce.enums.ExceptionEnum;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(){
        super(ExceptionEnum.CART_NOT_FOUND_EXCEPTION.getMessage());
    }
}
