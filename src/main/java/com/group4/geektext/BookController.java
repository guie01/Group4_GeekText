package com.group4.geektext;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/group4")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void registerBook(@RequestBody BookRegistrationRequest book) {
        bookService.registerBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
