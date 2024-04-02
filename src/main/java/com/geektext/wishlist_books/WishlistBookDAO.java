package com.geektext.wishlist_books;

import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;

public interface WishlistBookDAO {

    List<WishlistBook> findByW(Integer w);
    void deleteByWAndIsbn(Integer w, BigInteger isbn);
    public void registerWishlistBook(WishlistBook wishlistBook);

}
