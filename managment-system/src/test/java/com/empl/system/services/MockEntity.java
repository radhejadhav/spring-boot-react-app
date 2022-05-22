package com.empl.system.services;

public class MockEntity {

    private String name;
    private String userName;
    private String password;

    public MockEntity(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
