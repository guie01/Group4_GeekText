package com.geektext.bookComments;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public interface BookCommentsDAO {

    List<BookComments> getCommentsByBookIsbn(BigInteger isbn);


    void saveComment(BookComments bookComment);

}