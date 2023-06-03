package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    Double amount;
    Integer remainCount;
    @Embedded
    ProductDetails productDetails;

    @ManyToOne
    Brand brand;
    @OneToOne(cascade = CascadeType.PERSIST)
    Cart cart;

}





