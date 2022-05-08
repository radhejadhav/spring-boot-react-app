package com.empl.system.utils;

import java.util.Date;

public class AuthResponse {

    private String token;
    private String username;
    private int expiredInHr;

    public AuthResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiredInHr() {
        return expiredInHr;
    }

    public void setExpiredInHr(int expiredAt) {
        this.expiredInHr = expiredAt;
    }
}
