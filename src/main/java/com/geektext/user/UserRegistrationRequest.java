package com.geektext.user;

public record UserRegistrationRequest(String username, String password, String name, String email, String address) {
}
