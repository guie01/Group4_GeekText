package com.geektext.book_details.book;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;

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

    @GetMapping("/copiesSold")
    public List<Book> findTop10BooksByCopiesSoldDesc() { return bookService.getTop10BooksByCopiesSold();}

    @GetMapping("/booksByRating/{rating}")
    public List<Book> findByRatingGreaterThanEqualOrderByRatingDesc(@PathVariable("rating") Integer rating) {return bookService.getBooksByRatingAndHigher(rating);}

    @PatchMapping("/discountByPublisher") // ?publisher='publisher'&discount='discount'
    public ResponseEntity<Void> discountBooksByPublisher(@RequestParam("publisher") String publisher, @RequestParam("discount") BigDecimal discount) {
        bookService.discountBooksByPublisher(publisher, discount);
        return ResponseEntity.ok().build();}

}
