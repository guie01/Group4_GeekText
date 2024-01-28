package com.group4.geektext;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer edition;
    @Column(nullable = false)
    private Integer year;

    public Book(Integer id, String title, Integer edition, Integer year) {
        this.id = id;
        this.title = title;
        this.edition = edition;
        this.year = year;
    }

    public Book(String title, Integer edition, Integer year) {
        this.title = title;
        this.edition = edition;
        this.year = year;
    }

    public Book() {
    }
}
