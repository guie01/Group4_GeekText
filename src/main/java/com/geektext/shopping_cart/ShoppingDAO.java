package com.geektext.shopping_cart;

import java.math.BigInteger;
import java.util.List;

public interface ShoppingDAO {
    List<ShoppingCart> getBookByUserId(Integer userId);

    void saveOrUpdateCart(ShoppingCart cart);

    void deleteBookFromCart(BigInteger book_id, Integer userId);
}
