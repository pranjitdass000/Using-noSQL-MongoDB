package com.stackroute.restservicedemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.restservicedemo.model.User;
import com.stackroute.restservicedemo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    UserService userService;
    private User user;
    private List<User> userList;

    @InjectMocks
    UserController userController;

    @BeforeEach
    public void setUp(){
        user = new User(2,"riju","das",34);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @Test
    public void givenUserToSaveShouldReturnSavedUser() throws Exception {
        when(userService.saveUser(any())).thenReturn(user);
        mockMvc.perform(post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(status().isCreated());
        verify(userService,times(1)).saveUser(any());
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}