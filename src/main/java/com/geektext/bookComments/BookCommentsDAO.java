/*package com.geektext.bookComments;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;
import com.geektext.bookComments.BookCommentsRepository;

public interface BookCommentsDAO {

    void saveComment(BookComments bookComment);

    default List<BookComments> getCommentsByBookIsbn(BigInteger bookIsbn) {
        return bookCommentsRepository.findCommentsByBookIsbn(bookIsbn);
    }

    void setBookCommentsRepository(BookCommentsRepository bookCommentsRepository);
} */

package com.geektext.bookComments;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public interface BookCommentsDAO {

    List<BookComments> getCommentsByBookIsbn(BigInteger isbn);


    void saveComment(BookComments bookComment);

}