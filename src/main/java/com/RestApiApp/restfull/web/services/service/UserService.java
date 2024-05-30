package com.RestApiApp.restfull.web.services.service;

import com.RestApiApp.restfull.web.services.entity.User;
import com.RestApiApp.restfull.web.services.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){

        return userRepository.save(user);
    }

    public User updateUser(Long id, User user){
        Optional<User> existingUser=userRepository.findById(id);
        if (existingUser.isPresent()){
            User userInfo=existingUser.get();
            userInfo.setName(user.getName());
            userInfo.setEmail(user.getEmail());
            userInfo.setEmail(user.getEmail());
            userInfo.setPh_no(user.getPh_no());
           return userRepository.save(userInfo);
        }
        else {
            throw new RuntimeException("userDetails not found in database");
        }
    }

    public Optional<User> getUserInfo(Long id){
         return userRepository.findById(id);

    }
    public List<User> getAllUserInfo(){

        return userRepository.findAll();
    }

    public void deleteUser(Long id){
       userRepository.deleteById(id);
    }
}
