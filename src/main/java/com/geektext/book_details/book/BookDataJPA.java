package com.geektext.book_details.book;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class BookDataJPA implements BookDAO {

    @Autowired
    private final BookRepository bookRepository;

    @Override
    public boolean existsBookWithIsbn(BigInteger isbn) {
        return bookRepository.existsById(isbn);
    }

    @Override
    public void registerBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookByIsbn(BigInteger isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public List<Book> getBooksByAuthorId(Integer authorId) {
        return bookRepository.findBooksByAuthorId(authorId);
    }
}
