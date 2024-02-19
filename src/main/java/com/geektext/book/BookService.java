package com.geektext.book;

import com.geektext.book.BookDAO;
import com.geektext.book.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookDAO bookDAO;

    public void registerBook(BookRegistrationRequest request) {
        Book book = Book.builder()
                .isbn(request.isbn())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .genre(request.genre())
                .yearPublished(request.yearPublished())
                .copiesSold(request.copiesSold())
                .authorId(request.authorId())
                .publisher(request.publisher())
                .build();

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
