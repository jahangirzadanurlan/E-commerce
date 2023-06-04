package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.request.CartRequestDto;
import com.example.ecommerce.dto.response.CartResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.exception.CartNotFoundException;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseDto save(CartRequestDto cartRequestDto) {
        Cart cart=cartRepository.save(modelMapper.map(cartRequestDto,Cart.class));
        if(cart!=null){
            return new ResponseDto("Save is successfully!");
        }else {
            throw new CartNotFoundException();
        }

    }

    @Override
    public List<CartResponseDto> getAllCarts() {
        return cartRepository.findAll().stream()
                .map(cart -> modelMapper.map(cart,CartResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDto deleteCart(CartRequestDto cartRequestDto) {
        cartRepository.delete(modelMapper.map(cartRequestDto,Cart.class));
        return new ResponseDto("Deleted is successfully!");

    }
}
