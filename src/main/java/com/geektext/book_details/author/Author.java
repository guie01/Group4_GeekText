package com.geektext.book_details.author;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String biography;

    @Column(nullable = false)
    private String publisher;

    public Author(Integer id, String firstName, String lastName, String biography, String publisher) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
    }

    public Author(String firstName, String lastName, String biography, String publisher) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
    }

    public Author() {
    }
}
