package com.geektext.bookRatings;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;
@Data
@Table(name = "book_ratings")
@Entity
public class BookRatings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @Column(nullable = false)
    private BigInteger bookIsbn;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer ratingValue;

    @Column(nullable = false)
    private java.sql.Timestamp datestamp;
}
