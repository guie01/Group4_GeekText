package com.geektext.bookRatings;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Service
public class BookRatingsService {

    private final BookRatingsDAO bookRatingDAO;

    public List<BookRatings> getRatingsByBookIsbn(BigInteger bookIsbn) {
        return bookRatingDAO.getRatingsByBookIsbn(bookIsbn);
    }

    public void saveRating(BookRatings bookRating) {
        bookRatingDAO.saveRating(bookRating);
    }
    public void createRating(BookRatingsController.RatingRequest request) {
        BookRatings bookRating = new BookRatings();
        bookRating.setBookIsbn(request.getBookIsbn());
        bookRating.setUserId(request.getUserId());
        bookRating.setRatingValue(request.getRating());
        // You can set the datestamp here using current timestamp
        bookRating.setDatestamp(new java.sql.Timestamp(System.currentTimeMillis()));
        bookRatingDAO.saveRating(bookRating);
    }

}
