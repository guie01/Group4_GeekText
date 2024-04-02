package com.geektext.bookComments;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
@Table(name = "book_comments")
@Entity
public class BookComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(nullable = false)
    private BigInteger bookIsbn;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private String commentText;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date datestamp;

    // Constructors, getters, and setters
}