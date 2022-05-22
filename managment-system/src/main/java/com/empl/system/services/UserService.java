package com.empl.system.services;

import com.empl.system.daos.AuthUserDao;
import com.empl.system.entities.AuthUser;
import com.empl.system.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountExpiredException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired private AuthUserDao authUserDao;

    public UserService(AuthUserDao authUserDao) {
        this.authUserDao = authUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            AuthUser authUser = authUserDao.findByUsername(username);
            if(authUser != null && authUser.isCredentialsNonExpired()){
                return authUser;
            }
            throw new AccountExpiredException();
        }catch (UsernameNotFoundException | AccountExpiredException e){
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    public ResponseEntity<?> registerUser(AuthUser authUser){

        try {
            AuthUser user = authUserDao.findByUsername(authUser.getUsername());
            if(user != null && user.getUsername().equals(authUser.getUsername())){
                return ResponseEntity.badRequest().body(new ApiResponse(HttpStatus.BAD_REQUEST,"","User Already Present",HttpStatus.BAD_REQUEST.value()));
            }
            authUser.setPassword(new BCryptPasswordEncoder().encode(authUser.getPassword()));
            return ResponseEntity.accepted().body(new ApiResponse(HttpStatus.ACCEPTED,authUserDao.save(authUser),"",HttpStatus.ACCEPTED.value()));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<AuthUser> getAllUser(){

        return authUserDao.findAll();
    }
}
