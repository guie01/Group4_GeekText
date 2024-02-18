package com.geektext.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest {

    @Autowired
    private BookRepository underTest;

    @BeforeEach
    void setUp() {
        underTest.deleteAll();
    }

    @Test
    void findBookByYear() {
        //Given
        Book book1 = new Book("ABC123", 4, 2000);
        Book book2 = new Book("XYZ789", 2, 2000);
        Book book3 = new Book("IJK567", 3, 1999);

        underTest.save(book1);
        underTest.save(book2);
        underTest.save(book3);
        //When
        List<Book> books = underTest.findBookByYear(2000);
        //Then
        assertThat(books).contains(book1);
        assertThat(books).contains(book2);
        assertThat(books).doesNotContain(book3);
    }
}