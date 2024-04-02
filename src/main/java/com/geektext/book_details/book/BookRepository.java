package com.geektext.book_details.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository <Book, BigInteger> {

    List<Book> findBooksByAuthorId(Integer authorId);

    List<Book> findBooksByGenre(Genre genre);

    List<Book> findTop10ByOrderByCopiesSoldDesc();

    List<Book> findByRatingGreaterThanEqualOrderByRatingDesc(Integer rating);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.price = b.price * (1 - :discount / 100) WHERE b.publisher = :publisher")
    void applyDiscountByPublisher(@Param("discount") BigDecimal discount, @Param("publisher") String publisher);

}
