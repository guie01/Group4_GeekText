package com.geektext.bookRatings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface BookRatingsRepository extends JpaRepository<BookRatings, Long> {
    List<BookRatings> findByBookIsbn(BigInteger bookIsbn);

    @Query("SELECT AVG(r.ratingValue) FROM BookRatings r WHERE r.bookIsbn = :bookIsbn")
    Double findAverageRatingByBookIsbn(@Param("bookIsbn") BigInteger bookIsbn);
}
