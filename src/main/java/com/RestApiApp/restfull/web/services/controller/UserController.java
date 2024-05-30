package com.RestApiApp.restfull.web.services.controller;

import com.RestApiApp.restfull.web.services.entity.User;
import com.RestApiApp.restfull.web.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        return new ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id ,@RequestBody User user){
        //userService.updateUser(id, user);
         return new ResponseEntity<>(userService.updateUser(id,user),HttpStatus.OK);
       // return ResponseEntity.ok("Successfully updated user details in Database");
    }

    @GetMapping("/getUser/{id}")

    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserInfo(id), HttpStatus.OK);
        //return fetchedUser.map(body -> ResponseEntity.ok(body)).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getAllUserInfo(),HttpStatus.OK);
        //return ResponseEntity.of(Optional.ofNullable(userService.getAllUserInfo()));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Successfully deleted the user from the Database having id is ="+id);
    }
}
