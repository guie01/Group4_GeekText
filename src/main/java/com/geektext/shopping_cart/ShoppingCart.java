package com.geektext.shopping_cart;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@Table(name = "shopping_carts")
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private BigInteger bookId;


    public ShoppingCart(Integer id, Integer userId, BigInteger bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;

    }
       public ShoppingCart() {

    }

}






