package com.geektext.book_details.book;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface BookDAO {

    boolean existsBookWithIsbn(BigInteger isbn);
    void registerBook(Book book);
    Optional<Book> getBookByIsbn(BigInteger isbn);
    List<Book> getBooksByAuthorId(Integer authorId);
    List<Book> getBooksByGenre(Genre genre);

    List<Book> getTop10BooksByCopiesSold();
    List<Book> getBooksByRatingAndHigher(Integer rating);

    void applyDiscountByPublisher(BigDecimal discount, String Publisher );

}
