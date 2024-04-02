package com.geektext.wishlist;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WishlistService {

    private final WishlistDAO wishlistDAO;

    public void registerWishlist(Wishlist wishlist) {
        wishlistDAO.registerWishlist(wishlist);
    }


}
