package com.geektext.book_details.book;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/group4/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void registerBook(@RequestBody Book book) {
        bookService.registerBook(book);
    }

    @GetMapping("{isbn}")
    public Book getBookByIsbn(@PathVariable("isbn") BigInteger isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @GetMapping("/author/{authorId}")
    public List<Book> getBooksByAuthorId(@PathVariable("authorId") Integer authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> findBookByGenre(@PathVariable("genre") Genre genre) {
        return bookService.getBooksByGenre(genre);
    }



}
