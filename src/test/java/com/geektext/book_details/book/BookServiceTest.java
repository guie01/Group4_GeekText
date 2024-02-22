package com.geektext.book_details.book;

import com.geektext.book_details.author.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookDAO bookDAO;
    private BookService underTest;
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        underTest = new BookService(bookDAO, authorService);
    }

    @Test
    void existsBookWithIsbn() {
        //Given
        BigInteger isbn = new BigInteger("9234654332");
        String name = "ABC123";
        String description = "Random description...";
        BigDecimal price = new BigDecimal("100.00");
        Genre genre = Genre.FICTION;
        Integer yearPublished = 2000;
        Integer copiesSold = 10000;
        Integer authorId = 1;
        String publisher = "myself";

        Book book = new Book(isbn, name, description, price, authorId, genre, publisher, yearPublished, copiesSold);
        underTest.registerBook(book);
        //When
        boolean actual = underTest.existsBookWithIsbn(isbn);
        //Then
        assertThat(actual).isTrue();
    }

    @Test
    void registerBook() {
        //Given
        BigInteger isbn = new BigInteger("9234654332");
        String name = "ABC123";
        String description = "Random description...";
        BigDecimal price = new BigDecimal("100.00");
        Genre genre = Genre.FICTION;
        Integer yearPublished = 2000;
        Integer copiesSold = 10000;
        Integer authorId = 1;
        String publisher = "myself";

        Book book = new Book(isbn, name, description, price, authorId, genre, publisher, yearPublished, copiesSold);

        //When
        underTest.registerBook(book);
        //Then
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        Mockito.verify(bookDAO).registerBook(bookArgumentCaptor.capture());
        Book capturedBook = bookArgumentCaptor.getValue();

        assertThat(capturedBook.getIsbn()).isEqualTo(isbn);
        assertThat(capturedBook.getName()).isEqualTo(name);
        assertThat(capturedBook.getDescription()).isEqualTo(description);
        assertThat(capturedBook.getPrice()).isEqualTo(price);
        assertThat(capturedBook.getGenre()).isEqualTo(genre);
        assertThat(capturedBook.getYearPublished()).isEqualTo(yearPublished);
        assertThat(capturedBook.getCopiesSold()).isEqualTo(copiesSold);
        assertThat(capturedBook.getAuthorId()).isEqualTo(authorId);
        assertThat(capturedBook.getPublisher()).isEqualTo(publisher);
    }

    @Test
    void getBookByIsbn() {
        //Given
        BigInteger isbn = new BigInteger("9234654332");
        String name = "ABC123";
        String description = "Random description...";
        BigDecimal price = new BigDecimal("100.00");
        Genre genre = Genre.FICTION;
        Integer yearPublished = 2000;
        Integer copiesSold = 10000;
        Integer authorId = 1;
        String publisher = "myself";

        Book book = new Book(isbn, name, description, price, authorId, genre, publisher, yearPublished, copiesSold);
        underTest.registerBook(book);
        //When
        Book actual = underTest.getBookByIsbn(isbn);
        //Then
        assertThat(actual.getIsbn()).isEqualTo(isbn);
        assertThat(actual.getName()).isEqualTo(name);
        assertThat(actual.getDescription()).isEqualTo(description);
        assertThat(actual.getPrice()).isEqualTo(price);
        assertThat(actual.getGenre()).isEqualTo(genre);
        assertThat(actual.getYearPublished()).isEqualTo(yearPublished);
        assertThat(actual.getCopiesSold()).isEqualTo(copiesSold);
        assertThat(actual.getAuthorId()).isEqualTo(authorId);
        assertThat(actual.getPublisher()).isEqualTo(publisher);
    }
}