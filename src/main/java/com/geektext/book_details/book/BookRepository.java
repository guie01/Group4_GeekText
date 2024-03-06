package com.geektext.book_details.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, BigInteger> {

    List<Book> findBooksByAuthorId(Integer authorId);

    List<Book> findBooksByGenre(Genre genre);
}
