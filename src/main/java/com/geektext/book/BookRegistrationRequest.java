package com.geektext.book;

import java.math.BigDecimal;

public record BookRegistrationRequest(Integer isbn, String name, String description, BigDecimal price, Genre genre, Integer yearPublished, Integer copiesSold, Integer authorId, String publisher) {
}
