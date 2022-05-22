package com.empl.system.services;

import com.empl.system.daos.AuthUserDao;
import com.empl.system.entities.AuthUser;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    private AuthUser authUser;

    @Mock
    private AuthUserDao authUserDao;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        authUser = new AuthUser();
        authUser.setUsername("testUsername");
        authUser.setPassword("test");
        authUser.setEmail("test@gmail.com");
        authUser.setFirstName("testFirst");
        authUser.setLastName("testLast");
        authUser.setCompany("test.com");
    }

    @Test
    void loadUserByUsername() {
        Mockito.when(authUserDao.save(authUser)).then(new Answer<AuthUser>() {
            @Override
            public AuthUser answer(InvocationOnMock invocationOnMock) throws Throwable {
                AuthUser authUser =(AuthUser) invocationOnMock.getMock();
                return authUser;
            }
        });
        System.out.println(authUser.getUsername());
        Assert.assertNotNull(authUser);
    }

    @Test
    void registerUser() {

//        Mockito.
    }

    @Test
    void getAllUserTest(){
        List<AuthUser> userList = userService.getAllUser();
        Assert.assertNotNull(userList);

    }
}