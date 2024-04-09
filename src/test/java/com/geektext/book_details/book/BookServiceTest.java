package com.geektext.book_details.book;

import com.geektext.book_details.author.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookDAO bookDAO;
    @Mock
    private AuthorService authorService;
    private BookService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BookService(bookDAO, authorService);
    }


    @Test
    void existsBookWithIsbn() {
        //Given
        BigInteger isbn = new BigInteger("9234654332");
        Mockito.when(bookDAO.existsBookWithIsbn(isbn)).thenReturn(true);

        // When
        boolean exists = underTest.existsBookWithIsbn(isbn);

        // Then
        assertThat(exists).isTrue();
    }

    @Test
    void registerBook() {
        //Given
        BigInteger isbn = new BigInteger("9234654332");
        String name = "ABC123";
        String description = "Random description...";
        BigDecimal price = new BigDecimal("100.00");
        Integer authorId = 1;
        Mockito.when(authorService.existsAuthorWithId(authorId)).thenReturn(true);
        Genre genre = Genre.FICTION;
        Integer yearPublished = 2000;
        Integer copiesSold = 10000;
        String publisher = "myself";
        Integer rating = 5;

        Book book = new Book(isbn, name, description, price, authorId, genre, publisher, yearPublished, copiesSold, rating);

        //When
        underTest.registerBook(book);
        //Then
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        Mockito.verify(bookDAO).registerBook(bookArgumentCaptor.capture());
        Book capturedBook = bookArgumentCaptor.getValue();

        assertThat(book).isEqualTo(capturedBook);
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
        Integer authorId = 1;
        Genre genre = Genre.FICTION;
        Integer yearPublished = 2000;
        Integer copiesSold = 10000;
        String publisher = "myself";
        Integer rating = 5;

        Book expectedBook = new Book(isbn, name, description, price, authorId, genre, publisher, yearPublished, copiesSold, rating);
        Mockito.when(bookDAO.getBookByIsbn(isbn)).thenReturn(Optional.of(expectedBook));

        //When
        Book actualBook = underTest.getBookByIsbn(isbn);
        //Then
        assertThat(actualBook).isEqualTo(expectedBook);
    }

    @Test
    void getBooksByAuthorId() {
        //Given
        String name = "ABC123";
        String description = "Random description...";
        BigDecimal price = new BigDecimal("100.00");
        Integer authorId = 1;
        Mockito.when(authorService.existsAuthorWithId(authorId)).thenReturn(true);
        Genre genre = Genre.FICTION;
        Integer yearPublished = 2000;
        Integer copiesSold = 10000;
        String publisher = "myself";
        Integer rating = 5;

        Book expectedBook1 = new Book(new BigInteger("11111111111"), name, description, price, authorId, genre, publisher, yearPublished, copiesSold, rating);
        Book expectedBook2 = new Book(new BigInteger("22222222222"), name, description, price, authorId, genre, publisher, yearPublished, copiesSold, rating);
        Book expectedBook3 = new Book(new BigInteger("33333333333"), name, description, price, authorId, genre, publisher, yearPublished, copiesSold, rating);
        List<Book> expectedBooks = List.of(expectedBook1, expectedBook2, expectedBook3);

        Mockito.when(bookDAO.getBooksByAuthorId(1)).thenReturn(expectedBooks);
        //When
        List<Book> actualBooks = underTest.getBooksByAuthorId(authorId);
        //Then
        assertThat(actualBooks).containsAll(expectedBooks);
    }
}