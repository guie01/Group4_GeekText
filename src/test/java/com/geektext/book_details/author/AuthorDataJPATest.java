package com.geektext.book_details.author;

import com.geektext.book_details.book.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthorDataJPATest {

    private AuthorDataJPA underTest;
    @Mock
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        underTest = new AuthorDataJPA(authorRepository);
    }

    @Test
    void findAllAuthors() {
        //When
        underTest.findAllAuthors();
        //Then
        Mockito.verify(authorRepository).findAll();

    }

    @Test
    void registerAuthor() {
        //Given
        Author author = new Author(1, "Foo", "Bar", "Biography...", "Publisher A");
        //When
        underTest.registerAuthor(author);
        //Then
        Mockito.verify(authorRepository).save(author);
    }

    @Test
    void existsAuthorWithId() {
        //Given
        Integer id = 10;
        //When
        underTest.existsAuthorWithId(id);
        //Then
        Mockito.verify(authorRepository).existsById(id);
    }
}