package com.geektext.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookDAO bookDAO;

    public void registerBook(Book book) {
        // do any validation
         bookDAO.registerBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public List<Book> findBookByYear(Integer yearPublished) {
        // do any validation
        return bookDAO.findBookByYear(yearPublished);
    }
}
