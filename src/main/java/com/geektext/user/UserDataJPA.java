package com.geektext.user;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@AllArgsConstructor
public class UserDataJPA implements UserDAO{

    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public void registerUser(User user){
        userRepository.save(user);
    }
    @Override
   public boolean existsUserWithId(Integer id){
       return userRepository.existsById(id);
    }
    @Override
    public List<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void updateUser(User user){
        userRepository.save(user);
    }

}


