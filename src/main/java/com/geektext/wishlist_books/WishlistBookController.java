package com.geektext.wishlist_books;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api/group4/wishlist/unique")
public class WishlistBookController {

    private final WishlistBookService wishlistBookService;


    @GetMapping("{wishlist_id}")
    public List<WishlistBook> getWishlist(@PathVariable("wishlist_id") Integer w) {
        return wishlistBookService.findAllByW(w);
    }
    @DeleteMapping("/wishlist/{wishlist_id}/book/{isbn}")
    public void deleteBookFromWishlist(@PathVariable("wishlist_id") Integer w, @PathVariable("isbn") BigInteger isbn) {
        wishlistBookService.deleteByWAndIsbn(w, isbn);
    }

    @PostMapping
    public void registerWishlistBook(@RequestBody WishlistBook wishlistBook) {
        wishlistBookService.registerWishlistBook(wishlistBook);
    }

}
