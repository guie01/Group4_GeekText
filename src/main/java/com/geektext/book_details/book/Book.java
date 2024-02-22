package com.geektext.book_details.book;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@Table(name = "books")
@Entity
public class Book {

    @Id
    @Column(nullable = false)
    private BigInteger isbn;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer authorId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private Integer yearPublished;

    @Column(nullable = false)
    private Integer copiesSold;

    public Book(BigInteger isbn, String name, String description, BigDecimal price, Integer authorId, Genre genre, String publisher, Integer yearPublished, Integer copiesSold) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.authorId = authorId;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public Book() {
    }
}
