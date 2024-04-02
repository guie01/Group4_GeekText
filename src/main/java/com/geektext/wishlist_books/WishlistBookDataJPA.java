package com.geektext.wishlist_books;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Repository
public class WishlistBookDataJPA implements WishlistBookDAO {

    @Autowired
    private final WishlistBookRepository wishlistBookRepository;
    public List<WishlistBook> findByW(Integer w) {
        return wishlistBookRepository.findAllByW(w);
    }

    @Override
    public void deleteByWAndIsbn(Integer w, BigInteger isbn) {
        wishlistBookRepository.deleteByWAndIsbn(w, isbn);
    }

    public void registerWishlistBook(WishlistBook wishlistBook) {
        wishlistBookRepository.save(wishlistBook);
    }

}
