package com.geektext.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping( "api/group4/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        userService.registerUser(userRegistrationRequest);
    }

    @GetMapping("/{username}")
    public List<User> getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }

    @PutMapping("/{username}")
    public void updateUser(@PathVariable("username") String username, @RequestBody UpdateUserRequest updateUserRequest){
        userService.updateUserFields(username, updateUserRequest);
    }


}




