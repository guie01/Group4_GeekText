package com.geektext.book_details.author;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/group4/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public void registerAuthor(@RequestBody AuthorRegistrationRequest authorRegistrationRequest) {
        authorService.registerAuthor(authorRegistrationRequest);
    }
}
