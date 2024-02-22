package com.geektext.book_details.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
}