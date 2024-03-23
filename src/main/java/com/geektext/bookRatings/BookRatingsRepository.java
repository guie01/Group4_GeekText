package com.geektext.bookRatings;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface BookRatingsRepository extends JpaRepository<BookRatings, Long> {
    List<BookRatings> findByBookIsbn(BigInteger bookIsbn);
}
