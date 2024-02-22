package com.geektext.book_details.author;

import com.geektext.exceptions.DuplicateResourceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorService {

    private final AuthorDAO authorDAO;

    public boolean existsAuthor(Author author) {
        List<Author> authors = authorDAO.findAllAuthors();
        List<Author> list = authors.stream()
                .filter(target -> target.getFirstName().equals(author.getFirstName()))
                .filter(target -> target.getLastName().equals(author.getLastName()))
                .filter(target -> target.getBiography().equals(author.getBiography()))
                .filter(target -> target.getPublisher().equals(author.getPublisher()))
                .toList();
        return !list.isEmpty();
    }

    public void registerAuthor(AuthorRegistrationRequest request) {

        Author author = Author.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .biography(request.biography())
                .publisher(request.publisher())
                .build();

        if (!existsAuthor(author)) authorDAO.registerAuthor(author);
        else throw new DuplicateResourceException("Author [%s %s] already exists"
                .formatted(author.getFirstName(), author.getLastName()));
    }

    public boolean existsAuthorWithId(Integer id) {
        return authorDAO.existsAuthorWithId(id);
    }
}
