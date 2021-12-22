package com.stackroute.restservicedemo.service;

//import com.stackroute.restservicedemo.exception.UserAlreadyExistException;
import com.stackroute.restservicedemo.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user)  ;
    List<User> getAllUsers();
    void deleteAllUser();
    void deleteById(int id);
    void deleteByIdThroughRequestParam(int id);

    void updateUser(User user);

}
