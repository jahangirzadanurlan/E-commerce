package com.example.ecommerce.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionEnum {
    CATEGORY_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"Category not found!"),
    CART_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"Cart not found!"),
    BRAND_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"Brand not found"),

    ILLEGAL_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"Illegal Argument not found!");


    private final HttpStatus status;
    private final String message;


}
