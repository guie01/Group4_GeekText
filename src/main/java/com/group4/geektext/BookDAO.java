package com.group4.geektext;

import java.util.List;

public interface BookDAO {

    void registerBook(Book book);
    List<Book> getAllBooks();
}
