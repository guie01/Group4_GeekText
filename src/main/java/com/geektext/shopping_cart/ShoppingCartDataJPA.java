package com.geektext.shopping_cart;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
@AllArgsConstructor
public class ShoppingCartDataJPA implements ShoppingDAO {
    //implements methods


    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public List<ShoppingCart> getBookByUserId(Integer userId) {
        return shoppingCartRepository.findShoppingCartByUserId(userId);
    }

    @Override
    public void saveOrUpdateCart(ShoppingCart cart) {
        shoppingCartRepository.save(cart);
    }

    @Override
    public void deleteBookFromCart(BigInteger bookId, Integer userId) {
        shoppingCartRepository.deleteByUserIdAndBookId(userId, bookId);

    }
}
