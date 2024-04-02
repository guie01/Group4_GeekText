package com.geektext.book_details.author;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    private AuthorDAO authorDAO;
    private AuthorService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AuthorService(authorDAO);
    }

    @Test
    void existsAuthor() {
        //Given
        Author author = new Author(1, "Foo", "Bar", "Biography...", "Publisher A");
        List<Author> authors = List.of(author);
        Mockito.when(authorDAO.findAllAuthors()).thenReturn(authors);

        //When
        boolean exists = underTest.existsAuthor(author);
        //Then
        assertThat(exists).isTrue();
    }

    @Test
    void registerAuthor() {
        //Given
        AuthorRegistrationRequest author = new AuthorRegistrationRequest("Foo", "Bar", "Biography...", "Publisher A");
        //When
        underTest.registerAuthor(author);
        //Then
        ArgumentCaptor<Author> authorArgumentCaptor = ArgumentCaptor.forClass(Author.class);
        verify(authorDAO).registerAuthor(authorArgumentCaptor.capture());
        Author capturedAuthor = authorArgumentCaptor.getValue();

        assertThat(capturedAuthor.getFirstName()).isEqualTo(author.firstName());
        assertThat(capturedAuthor.getLastName()).isEqualTo(author.lastName());
        assertThat(capturedAuthor.getBiography()).isEqualTo(author.biography());
        assertThat(capturedAuthor.getPublisher()).isEqualTo(author.publisher());
    }

    @Test
    void existsAuthorWithId() {
        //Given
        Integer id = 5;
        Mockito.when(authorDAO.existsAuthorWithId(id)).thenReturn(true);
        //When
        boolean exists = underTest.existsAuthorWithId(id);
        //Then
        assertThat(exists).isEqualTo(true);
    }
}