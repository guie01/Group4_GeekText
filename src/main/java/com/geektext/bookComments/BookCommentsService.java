package com.geektext.bookComments;

import com.geektext.bookRatings.BookRatings;
import com.geektext.bookRatings.BookRatingsController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BookCommentsService {

    private final BookCommentsDAO bookCommentDAO;

    public List<BookComments> getCommentsByBookIsbn(BigInteger isbn) {
        return bookCommentDAO.getCommentsByBookIsbn(isbn);
    }

    /*public List<String> getCommentTextsByBookIsbn(BigInteger bookIsbn) {
        List<BookComments> comments = bookCommentDAO.getCommentsByBookIsbn(bookIsbn);
        List<String> commentTexts = new ArrayList<>();
        for (BookComments comment : comments) {
            commentTexts.add(comment.getCommentText());
        }
        return commentTexts;
    }*/


    public void saveComment(BookComments bookComment) {
        bookCommentDAO.saveComment(bookComment);
    }
    public void createComment(BookCommentsController.CommentRequest request) {
        BookComments bookComment = new BookComments();
        bookComment.setBookIsbn(request.getBookIsbn());
        bookComment.setUserId(request.getUserId());
        bookComment.setCommentText(request.getComment());
        // You can set the datestamp here using current timestamp
        bookComment.setDatestamp(new java.sql.Timestamp(System.currentTimeMillis()));
        bookCommentDAO.saveComment(bookComment);
    }

}
