package com.geektext.book_details.author;

import com.geektext.exceptions.DuplicateResourceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AuthorDataJPA implements AuthorDAO {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void registerAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public boolean existsAuthorWithId(Integer id) {
        return authorRepository.existsById(id);
    }
}
