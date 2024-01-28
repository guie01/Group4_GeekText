package com.geektext.book;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookDataJPATest {

    private BookDataJPA underTest;
    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        underTest = new BookDataJPA(bookRepository);
    }

    @Test
    void registerBook() {
        //Given
        Book book = new Book();
        //When
        underTest.registerBook(book);
        //Then
        Mockito.verify(bookRepository).save(book);
    }

    @Test
    void getAllBooks() {
        //When
        underTest.getAllBooks();
        //Then
        Mockito.verify(bookRepository).findAll();
    }

    @Test
    void getBooksByYear() {
        //Given
        int year = 2000;
        //When
        underTest.findBookByYear(year);
        //Then
        Mockito.verify(bookRepository).findBookByYear(year);
    }
}