package com.geektext.book_details.book;

import com.geektext.book_details.author.AuthorService;
import com.geektext.exceptions.ResourceNotFoundException;
import com.geektext.exceptions.DuplicateResourceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookDAO bookDAO;
    private final AuthorService authorService;

    public boolean existsBookWithIsbn(BigInteger isbn) {
        return bookDAO.existsBookWithIsbn(isbn);
    }

    public void registerBook(Book book) {

        if (!authorService.existsAuthorWithId(book.getAuthorId()))
            throw new ResourceNotFoundException("Author with id [%d] was not found".formatted(book.getAuthorId()));

        if (!existsBookWithIsbn(book.getIsbn()))
            bookDAO.registerBook(book);
        else throw new DuplicateResourceException("Book with isbn [%d] already exists".formatted(book.getIsbn()));

    }

    public Book getBookByIsbn(BigInteger isbn) {
        return bookDAO.getBookByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("Book with isbn [%d] not found".formatted(isbn)));
    }

    public List<Book> getBooksByAuthorId(Integer authorId) {
        if (!authorService.existsAuthorWithId(authorId)) {
            throw new ResourceNotFoundException("Author with id [%d] is not registered".formatted(authorId));
        }

        List<Book> booksByAuthor = bookDAO.getBooksByAuthorId(authorId);
        if (!booksByAuthor.isEmpty()) return booksByAuthor;
        else throw new ResourceNotFoundException("Author with id [%d] doesn't have books");
    }
}
