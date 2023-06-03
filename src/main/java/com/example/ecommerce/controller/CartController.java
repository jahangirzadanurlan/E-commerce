package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.CartRequestDto;
import com.example.ecommerce.dto.response.CartResponseDto;
import com.example.ecommerce.dto.response.ResponseDto;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Client;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.ClientRepository;
import com.example.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final ModelMapper modelMapper;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    @GetMapping
    List<CartResponseDto> getAllCart(){
        return cartRepository.findAll().stream()
                .map(cart -> modelMapper.map(cart,CartResponseDto.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/{cl_id}/product/{pr_id}")
    public ResponseDto saveCart(@RequestBody CartRequestDto cartRequestDto,@PathVariable Long cl_id,@PathVariable Long pr_id){
        Cart cart=modelMapper.map(cartRequestDto,Cart.class);
        Product product=productRepository.findProductById(pr_id);
        Client client= clientRepository.findClientById(cl_id);
        if (product != null) {
            cart.setProduct(product);
            cart.setClient(client);
            cartRepository.save(cart);
            return new ResponseDto("Save is successful!");
        } else {
            return new ResponseDto("Invalid id!");
        }
        //Total Amount null gedir
    }
    @PutMapping
    public ResponseDto updateCart(@RequestBody CartRequestDto cart){
        Cart save = cartRepository.save(modelMapper.map(cart, Cart.class));
        return save!=null ? new ResponseDto("Update is successfully!"):
                new ResponseDto("Update is unsuccessfully!!!");
    }
    @DeleteMapping("/{id}")
    public ResponseDto deleteCart(@PathVariable Long id){
        Cart cart=cartRepository.findById(id).orElseThrow();
        cartRepository.delete(cart);
        return new ResponseDto("Deleted successfully!");
    }

}
