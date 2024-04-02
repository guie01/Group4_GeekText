package com.geektext.wishlist;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class WishlistDataJPA implements WishlistDAO{

    @Autowired
     private final WishlistRepository wishlistRepository;
     public void registerWishlist(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }
}
