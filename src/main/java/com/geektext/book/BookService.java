package com.geektext.book;

import com.geektext.book.BookDAO;
import com.geektext.book.BookRegistrationRequest;
import com.geektext.book.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookDAO bookDAO;

    public void registerBook(BookRegistrationRequest bookRegistrationRequest) {
        // do any validation

        Book book = Book.builder()
                .title(bookRegistrationRequest.title())
                .edition(bookRegistrationRequest.edition())
                .year(bookRegistrationRequest.year())
                .build();
         bookDAO.registerBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public List<Book> findBookByYear(Integer year) {
        // do any validation
        return bookDAO.findBookByYear(year);
    }
}
