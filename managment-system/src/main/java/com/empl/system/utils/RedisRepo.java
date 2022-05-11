package com.empl.system.utils;

import com.empl.system.entities.AuthUser;
import com.empl.system.entities.RedisUserSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepo extends CrudRepository<RedisUserSession, String> {
}
