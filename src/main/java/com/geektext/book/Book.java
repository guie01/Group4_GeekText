package com.geektext.book;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Year;

@Data
@Builder
@Table(name = "books")
@Entity
public class Book {

    @Id
    private Integer isbn;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Genre genre;
    @Column(nullable = false)
    private Integer yearPublished;
    @Column(nullable = false)
    private Integer copiesSold;
    @Column(nullable = false)
    private Integer authorId;
    @Column(nullable = false)
    private String publisher;

    public Book(Integer isbn, String name, String description, BigDecimal price, Genre genre, Integer yearPublished, Integer copiesSold, Integer authorId, String publisher) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.authorId = authorId;
        this.publisher = publisher;
    }

    public Book() {
    }
}
