package com.stackroute.restservicedemo.service;

//import com.stackroute.restservicedemo.exception.UserAlreadyExistException;
import com.stackroute.restservicedemo.model.User;
import com.stackroute.restservicedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)

    /**
     * Userepositpry userRepository=New UserRepository();
     * UserServiceImpl userServiceImple = new UserServiceImpl(userRepository);
     */
    {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user)  {
        User savedUser = userRepository.save(user);

        return savedUser ;
    }

    @Override
    public List<User> getAllUsers() {

       List <User> userList = (List<User>) userRepository.findAll();
       return userList;
    }

    @Override
    public void deleteAllUser() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByIdThroughRequestParam(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);


    }
}
