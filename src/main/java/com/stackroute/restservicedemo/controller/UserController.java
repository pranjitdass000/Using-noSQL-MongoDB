package com.stackroute.restservicedemo.controller;

import com.stackroute.restservicedemo.model.User;
import com.stackroute.restservicedemo.repository.UserRepository;
import com.stackroute.restservicedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserService userService;
/* UserService userService - new UserService(); */
/* UserController userController = new UserController(UserService); */
    @Autowired /*constructor based autowiring */
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @Autowired  /* field autowired */
    UserRepository userRepository;


    public UserRepository getUserRepository() {
        return userRepository;
    }
//    @Autowired /* setter based auto wiring */
//
//    public void setUserRepository(UserRepository abcUserRepository) {
//        this.userRepository = abcUserRepository;
//    }

    @PostMapping("/user")
    //    <return_type/void> methodName(input);
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
//        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
    @GetMapping("/users")
    //    <return_type/void> methodName(input);
    public ResponseEntity<List<User>> getAllUsers()

    {
       List<User> retrivedUsers = userService.getAllUsers();
        return new ResponseEntity<List<User>>(retrivedUsers,HttpStatus.OK);

    }
    @DeleteMapping("/users")
    public String deleteSobUsers(){
        userService.deleteAllUser();
        return "deleted all users";

    }
    @DeleteMapping("/user/{id}")

    public  String deleteById(@PathVariable int id){
        System.out.println("id received= " + id);
        userService.deleteById(id);
        return "deleted user with Id" + id;


    }
    @DeleteMapping("/user")
    public String deleteUserByIdRequestParam(@RequestParam int id){
        userService.deleteByIdThroughRequestParam(id);
        return "deleted user with Id" + id;
    }
    @PutMapping("/user")
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return "user updated";

    }


}
