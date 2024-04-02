package com.geektext.bookComments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface BookCommentsRepository extends JpaRepository<BookComments, Integer> {

    List<BookComments> findCommentsByBookIsbn(BigInteger isbn);
}