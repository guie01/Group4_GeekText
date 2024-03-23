package com.geektext.bookRatings;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Repository
public class BookRatingsDataJPA implements BookRatingsDAO {

    @Autowired
    private final BookRatingsRepository bookRatingRepository;

    @Override
    public List<BookRatings> getRatingsByBookIsbn(BigInteger bookIsbn) {
        return bookRatingRepository.findByBookIsbn(bookIsbn);
    }

    @Override
    public void saveRating(BookRatings bookRating) {
        bookRatingRepository.save(bookRating);
    }
}
