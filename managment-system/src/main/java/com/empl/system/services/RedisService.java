package com.empl.system.services;

import com.empl.system.entities.RedisUserSession;
import com.empl.system.utils.AuthResponse;
import com.empl.system.utils.RedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisRepo redisRepo;

    public void addUserSession(RedisUserSession userSession){
        redisRepo.save(userSession);
    }

    public RedisUserSession getUserSession(String key){
        return redisRepo.findById(key).get();
    }

    public void logout(RedisUserSession userSession){
        redisRepo.delete(userSession);
    }
}
