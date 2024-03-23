package com.geektext.bookRatings;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/group4/bookRatings")
public class BookRatingsController {

    private final BookRatingsService bookRatingService;

    @GetMapping("{isbn}")
    public List<BookRatings> getRatingsByBookIsbn(@PathVariable("isbn") BigInteger bookIsbn) {
        return bookRatingService.getRatingsByBookIsbn(bookIsbn);
    }

    @PostMapping("/create")
    public void createRating(@RequestBody RatingRequest request) {
        bookRatingService.createRating(request);
    }

    public static class RatingRequest {
        private int rating;
        private int userId;
        private BigInteger bookIsbn;

        // Getters and setters
        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public BigInteger getBookIsbn() {
            return bookIsbn;
        }

        public void setBookIsbn(BigInteger bookIsbn) {
            this.bookIsbn = bookIsbn;
        }
    }
}
