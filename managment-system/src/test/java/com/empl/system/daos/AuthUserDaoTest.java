package com.empl.system.daos;

import com.empl.system.entities.AuthUser;
import com.empl.system.services.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AuthUserDaoTest {

    @Autowired
    UserService userService;

    @Autowired
    AuthUserDao authUserDao;

    @Test
    void contextLoad(){
        Assert.assertNotNull(userService);
    }

    @Test
    void findByUsername(){

        AuthUser expect = authUserDao.findByUsername("radhejadhav@gmail.com");

        Assert.assertEquals(expect.getUsername(),"radhejadhav@gmail.com");

    }
}