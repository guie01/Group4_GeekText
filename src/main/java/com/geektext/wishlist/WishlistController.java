package com.geektext.wishlist;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@AllArgsConstructor
@RestController
@RequestMapping("api/group4/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    @PostMapping
    public void registerWishlist(@RequestBody Wishlist wishlist) {
        wishlistService.registerWishlist(wishlist);
    }

}
