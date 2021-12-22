package com.stackroute.restservicedemo.service;

import com.stackroute.restservicedemo.model.User;
import com.stackroute.restservicedemo.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    List<User> userList;

    @Mock
    private UserRepository userMockRepository;

    @InjectMocks
    // UserServiceImpl userService = new UserServiceImpl(userMockRepository);
    private UserServiceImpl userService;


    private User user; //user is a class variable
//    @BeforeAll
//    public static void setupBeforeALllTestCasesRun(){
//        System.out.println("Inside @BeforeAll");
//    }
//
//    @AfterAll
//    public static void tearUpAfterALllTestCasesRun(){
//        System.out.println("Inside @AfterAll");
//    }


    @BeforeEach
public void setup(){
    System.out.println("Inside @BeforeEach setup");
     user = new User(1,"pranjit","das",34);
     userList = new ArrayList<User>();
     userList.add(user);

}
    @AfterEach
    public void tearDown(){
        System.out.println("Inside @AfterEach tearDown");
        user = null;
    }

    @Test
    public void givenUserToSaveShouldReturnSaveUser(){
        System.out.println("test givenUserToSaveShouldReturnSaveUse");
        when(userMockRepository.save(any())).thenReturn(user); //method stubbing
        userService.saveUser(user);
        verify(userMockRepository,times(1)).save(any());
    }
    @Test
    public void givenGetAllUserThenShouldReturnListOfAllUsers(){
        System.out.println("Test givenGetAllUserThenShouldReturnListOfAllUsers");
        userMockRepository.save(user);
        when(userMockRepository.findAll()).thenReturn(userList);
        List<User> userList = userService.getAllUsers();
        assertEquals(userList,userList);
        verify(userMockRepository,times(1)).save(user);
        verify(userMockRepository,times(1)).findAll();

    }


}