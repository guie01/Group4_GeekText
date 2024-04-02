package com.geektext.wishlist_books;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface WishlistBookRepository extends JpaRepository<WishlistBook, Integer> {
    List<WishlistBook> findAllByW(Integer w);
    void deleteByWAndIsbn(Integer w, BigInteger isbn);
}
