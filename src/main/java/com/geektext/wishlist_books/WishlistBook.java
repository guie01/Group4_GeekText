package com.geektext.wishlist_books;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
@Table(name = "wishlists_books")
@Entity
public class WishlistBook {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer w;

    @Column(nullable = false)
    private BigInteger isbn;

    public WishlistBook(Integer id, Integer w, BigInteger isbn) {
        this.id = id;
        this.w = w;
        this.isbn = isbn;
    }

    public WishlistBook() {
    }
}
