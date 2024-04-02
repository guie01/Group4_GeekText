package com.geektext.user;

public record UpdateUserRequest(String username, String password, String name, String email, String address) {
}
