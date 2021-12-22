package com.stackroute.restservicedemo.repository;

import com.stackroute.restservicedemo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//import javax.persistence.Entity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //integrates stringtest context framework into junit5
@DataJpaTest
//@SpringBootTest
public class UserRepositoryTest {     //testclass

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUserToSaveShouldReturnSavedUserWithCorrectFirstName(){ //testcases

        User user = new User(1,"pranjit","das",34);
        userRepository.save(user);
        User returnedUser = userRepository.findById(user.getId()).get();
        assertNotNull(returnedUser);
        assertEquals("pranjit",returnedUser.getFirstName());


    }

    @Test
    public void givenUserToSaveShouldReturnSavedUserWithCorrectAge(){

        User user = new User(1,"pranjit","das",34);
        userRepository.save(user);
        User returnedUser1 = userRepository.findById(user.getId()).get();
        assertNotNull(returnedUser1);

        assertEquals(34,returnedUser1.getAge());

    }


}