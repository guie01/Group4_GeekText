package com.geektext.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookDAO bookDAO;
    private BookService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BookService(bookDAO);
    }

    @Test
    void registerBook() {
        //Given
        int isbn = 01234567;
        String name = "ABC123";
        String description = "Random description...";
        BigDecimal price = new BigDecimal(100.00);
        Genre genre = Genre.HORROR;
        Integer yearPublished = 2000;
        Integer copiesSold = 10000;
        Integer authorId = 1;
        String publisher = "myself";

        BookRegistrationRequest request = new BookRegistrationRequest(isbn, name, description, price, genre, yearPublished, copiesSold, authorId, publisher);

        //When
        underTest.registerBook(request);
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
    void getAllBooks() {
        //When
        underTest.getAllBooks();
        //Then
        Mockito.verify(bookDAO).getAllBooks();
    }

    @Test
    void findBookByYear() {
        //Given
        int year = 2000;
        //When
        underTest.findBookByYear(year);
        //Then
        Mockito.verify(bookDAO).findBookByYear(year);
    }
}