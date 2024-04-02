package com.geektext.book_details.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

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
    void existsBookWithIsbn() {
        //Given
        BigInteger isbn = new BigInteger("0123456789");
        //When
        underTest.existsBookWithIsbn(isbn);
        //Then
        Mockito.verify(bookRepository).existsById(isbn);
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
    void getBooksByIsbn() {
        //Given
        BigInteger isbn = new BigInteger("0123456789");
        //When
        underTest.getBookByIsbn(isbn);
        //Then
        Mockito.verify(bookRepository).findById(isbn);
    }

    @Test
    void getBooksByAuthorId() {
        //Given
        Integer authorId = 10;
        //When
        underTest.getBooksByAuthorId(authorId);
        //Then
        Mockito.verify(bookRepository).findBooksByAuthorId(authorId);
    }
}