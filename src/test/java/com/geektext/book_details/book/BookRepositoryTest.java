package com.geektext.book_details.book;

import com.geektext.AbstractTestContainers;
import com.geektext.book_details.author.Author;
import com.geektext.book_details.author.AuthorRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest extends AbstractTestContainers {

    @Autowired
    private BookRepository underTest;
    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        underTest.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    void findBooksByAuthorId() {
        //Given
        Author author1 = new Author("Alex", "Smith", "Random biography", "Publisher A");
        Author author2 = new Author("Alexandra", "Smith", "Random biography", "Publisher B");

        authorRepository.save(author1);
        authorRepository.save(author2);

        Book book1 = new Book(new BigInteger("9323423523"), "ABC123", "Random description", new BigDecimal("100.00"), author1.getId(), Genre.HORROR, "myself", 2000, 1000);
        Book book2 = new Book(new BigInteger("9845635634"), "ABC123", "Random description", new BigDecimal("100.00"), author1.getId(), Genre.DRAMA, "myself", 2000, 1000);
        Book book3 = new Book(new BigInteger("9346278345"), "ABC123", "Random description", new BigDecimal("100.00"), author2.getId(), Genre.FICTION, "myself", 2001, 1000);

        underTest.save(book1);
        underTest.save(book2);
        underTest.save(book3);
        //When
        List<Book> books = underTest.findBooksByAuthorId(book1.getAuthorId());
        //Then
        assertThat(books).contains(book1);
        assertThat(books).contains(book2);
        assertThat(books).doesNotContain(book3);
    }
}