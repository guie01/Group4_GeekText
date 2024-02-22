package com.geektext.book_details.author;

import java.util.List;

public interface AuthorDAO {

    List<Author> findAllAuthors();
    void registerAuthor(Author author);
    boolean existsAuthorWithId(Integer id);

}
