package com.geektext.wishlist_books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class WishlistBookService {

    private final WishlistBookDAO wishlistBookDAO;

    public List<WishlistBook> findAllByW(Integer w) {

        return wishlistBookDAO.findByW(w);
    }

    public void deleteByWAndIsbn(Integer w, BigInteger isbn) {
        wishlistBookDAO.deleteByWAndIsbn(w, isbn);
    }

    public void registerWishlistBook( WishlistBook wishlistBook) {
        wishlistBookDAO.registerWishlistBook(wishlistBook);
    }



}
