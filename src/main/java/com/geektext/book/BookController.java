package com.geektext.book;

import com.geektext.book.BookRegistrationRequest;
import com.geektext.book.BookService;
import com.geektext.book.Book;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/group4")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void registerBook(@RequestBody Book book) {
        bookService.registerBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("{year}")
    public List<Book> findBookByYear(@PathVariable("year") Integer yearPublished) {
        return bookService.findBookByYear(yearPublished);
    }
}
