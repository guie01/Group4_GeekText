package com.geektext.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        String title = "ABC123";
        int edition = 3;
        int year = 2000;

        BookRegistrationRequest request = new BookRegistrationRequest(title, edition, year);
        //When
        underTest.registerBook(request);
        //Then
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        Mockito.verify(bookDAO).registerBook(bookArgumentCaptor.capture());
        Book capturedBook = bookArgumentCaptor.getValue();


        assertThat(capturedBook.getId()).isNull();
        assertThat(capturedBook.getTitle()).isEqualTo(title);
        assertThat(capturedBook.getEdition()).isEqualTo(edition);
        assertThat(capturedBook.getYear()).isEqualTo(year);
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