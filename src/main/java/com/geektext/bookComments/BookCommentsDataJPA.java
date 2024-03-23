package com.geektext.bookComments;

import com.geektext.bookRatings.BookRatings;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Repository
public class BookCommentsDataJPA implements BookCommentsDAO {

    @Autowired
    private final BookCommentsRepository bookCommentRepository;

    @Override
    public List<BookComments> getCommentsByBookIsbn(BigInteger isbn) {
        return bookCommentRepository.findCommentsByBookIsbn(isbn);
    }

    @Override
    public void saveComment(BookComments bookComment) {
        bookCommentRepository.save(bookComment);
    }
}