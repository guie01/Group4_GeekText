package com.geektext.book_details.book;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class BookDataJPA implements BookDAO {

    @Autowired
    private final BookRepository bookRepository;

    @Override
    public boolean existsBookWithIsbn(BigInteger isbn) {
        return bookRepository.existsById(isbn);
    }

    @Override
    public void registerBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookByIsbn(BigInteger isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public List<Book> getBooksByAuthorId(Integer authorId) {
        return bookRepository.findBooksByAuthorId(authorId);
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return bookRepository.findBooksByGenre(genre);
    }

    @Override
    public List<Book> getTop10BooksByCopiesSold() { return bookRepository.findTop10ByOrderByCopiesSoldDesc();}

    @Override
    public List<Book> getBooksByRatingAndHigher(Integer rating) {return bookRepository.findByRatingGreaterThanEqualOrderByRatingDesc(rating);}

    @Override
    public void applyDiscountByPublisher(BigDecimal discount, String publisher) {
        bookRepository.applyDiscountByPublisher(discount, publisher);
    }
}
