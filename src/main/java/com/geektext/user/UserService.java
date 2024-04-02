package com.geektext.user;
import com.geektext.exceptions.ResourceNotFoundException;
import com.geektext.exceptions.DuplicateResourceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserService {


    private final UserDAO userDAO;

    public boolean existsUser(User user){

        List<User> users = userDAO.findAllUsers();
        List<User> list = users.stream()
                .filter(target -> target.getUsername().equals(user.getUsername()))
                .filter(target -> target.getPassword().equals(user.getPassword()))
                .filter(target -> target.getName().equals(user.getName()))
                .filter(target -> target.getEmail().equals(user.getEmail()))
                .filter(target -> target.getAddress().equals(user.getAddress()))
                .toList();
        return !list.isEmpty();
    }

    public void registerUser(UserRegistrationRequest request){

        User user = User.builder()
                .username(request.username())
                .password(request.password())
                .name(request.name())
                .email(request.email())
                .address(request.address())
                .build();

        if (!existsUser(user)) userDAO.registerUser(user);
        else throw new DuplicateResourceException("User [%s] already exists".formatted(user.getUsername()));

    }
    public boolean existsUserWithID(Integer id){
       return userDAO.existsUserWithId(id);
    }
    public List <User> getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public void updateUserFields(String username, UpdateUserRequest updateUserRequest) {
        // Retrieve the user by username
        List<User> users = userDAO.getUserByUsername(username);

        if (!users.isEmpty()) {
            User user = users.get(0); // Assuming username is unique, get the first user
            // Update user fields with the new parameter values

            if (updateUserRequest.password() != null) {
                user.setPassword(updateUserRequest.password());

            } if (updateUserRequest.name() != null) {
                user.setName(updateUserRequest.name());
            }

            // Do not update the email field

            if (updateUserRequest.address() != null) {
                user.setAddress(updateUserRequest.address());
            }

            // Update the user in the database
            userDAO.updateUser(user);
        }
     else {
            // Handle case when no user is found with the given username
            throw new ResourceNotFoundException("User with username [%s] not found".formatted(username));
        }
    }
    public int getUserIdByUsername(String username) {
        List<User> users = userDAO.getUserByUsername(username);
        if (!users.isEmpty()) {
            return users.get(0).getId(); // Assuming User object has a getId() method returning an int
        } else {
            throw new ResourceNotFoundException("User with username [%s] not found".formatted(username));
        }
    }
}



