package com.geektext.book;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

@AllArgsConstructor
@Repository
public class BookDataJPA implements BookDAO {

    @Autowired
    private final BookRepository bookRepository;

    public void registerBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBookByYear(Integer yearPublished) {
        return bookRepository.findBookByYearPublished(yearPublished);
    }
}
