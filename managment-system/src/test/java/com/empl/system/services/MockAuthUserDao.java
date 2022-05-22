package com.empl.system.services;

import com.empl.system.entities.AuthUser;

public class MockAuthUserDao {

    public MockEntity findByUsername(String username){

        MockEntity mockEntity = new MockEntity("testName", username,"test");
        return  mockEntity;
    }
}
