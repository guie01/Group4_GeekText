package com.geektext.shopping_cart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findShoppingCartByUserId(int userId);



    void deleteByUserIdAndBookId(int userId, BigInteger bookId);

}

