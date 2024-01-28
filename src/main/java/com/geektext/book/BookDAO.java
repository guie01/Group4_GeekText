package com.geektext.book;

import java.util.List;

public interface BookDAO {

    void registerBook(Book book);
    List<Book> getAllBooks();
    List<Book> findBookByYear(Integer year);
}
