package com.geektext.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBookByYearPublished(Integer yearPublished);
}
