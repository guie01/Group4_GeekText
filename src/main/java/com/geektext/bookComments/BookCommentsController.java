package com.geektext.bookComments;

import com.geektext.bookRatings.BookRatingsController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/group4/bookComments")
public class BookCommentsController {

    private final BookCommentsService bookCommentService;

    @GetMapping("/book/{isbn}")
    public List<BookComments> getCommentsByBookIsbn(@PathVariable("isbn") BigInteger isbn) {
        return bookCommentService.getCommentsByBookIsbn(isbn);
    }

    /*@GetMapping("/{isbn}comments")
    public List<String> getCommentTextsByBookIsbn(@PathVariable("isbn") BigInteger bookIsbn) {
        return bookCommentService.getCommentTextsByBookIsbn(bookIsbn);
    } */

    @PostMapping("/create")
    public void createRating(@RequestBody BookCommentsController.CommentRequest request) {
        bookCommentService.createComment(request);
    }

    public static class CommentRequest {
        private String comment;
        private int userId;
        private BigInteger bookIsbn;

        // Getters and setters
        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
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