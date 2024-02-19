package com.geektext.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
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
        Book book1 = new Book(012345, "ABC123", "Random description", new BigDecimal("100.00"), Genre.HORROR, 2000, 1000, 1, "myself");
        Book book2 = new Book(123456, "ABC123", "Random description", new BigDecimal("100.00"), Genre.HORROR, 2000, 1000, 1, "myself");
        Book book3 = new Book(234567, "ABC123", "Random description", new BigDecimal("100.00"), Genre.HORROR, 2000, 1000, 1, "myself");

        underTest.save(book1);
        underTest.save(book2);
        underTest.save(book3);
        //When
        List<Book> books = underTest.findBookByYearPublished(2000);
        //Then
        assertThat(books).contains(book1);
        assertThat(books).contains(book2);
        assertThat(books).doesNotContain(book3);
    }
}