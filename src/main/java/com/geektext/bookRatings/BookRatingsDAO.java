package com.geektext.bookRatings;

import java.math.BigInteger;
import java.util.List;

public interface BookRatingsDAO {
    List<BookRatings> getRatingsByBookIsbn(BigInteger bookIsbn);
    void saveRating(BookRatings bookRating);
}
