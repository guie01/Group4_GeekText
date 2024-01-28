package com.group4.geektext;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookDataJPA bookDataJPA;

    public void registerBook(BookRegistrationRequest bookRegistrationRequest) {
        // do any validation

        Book book = Book.builder()
                .title(bookRegistrationRequest.title())
                .edition(bookRegistrationRequest.edition())
                .year(bookRegistrationRequest.year())
                .build();
        bookDataJPA.registerBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDataJPA.getAllBooks();
    }
}
