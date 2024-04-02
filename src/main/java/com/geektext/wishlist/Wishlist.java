package com.geektext.wishlist;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


import java.math.BigInteger;

@Data
@Builder
@Table(name = "wishlists")
@Entity
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer user_id;

    @Column(nullable = false)
    private Integer w_id;

    @Column(nullable = false)
    private String wishlist_name;


    public Wishlist(Integer id, Integer user_id, Integer w_id, String wishlist_name) {
        this.id = id;
        this.user_id = user_id;
        this.w_id = w_id;
        this.wishlist_name = wishlist_name;
    }

    public Wishlist() {
    }
}
