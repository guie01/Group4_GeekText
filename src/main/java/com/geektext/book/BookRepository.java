package com.geektext.book;

import com.geektext.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBookByYear(Integer year);
}
