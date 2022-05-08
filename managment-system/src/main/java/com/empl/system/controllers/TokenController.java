package com.empl.system.controllers;

import com.empl.system.entities.AuthUser;
import com.empl.system.services.UserService;
import com.empl.system.utils.ApiResponse;
import com.empl.system.utils.AuthResponse;
import com.empl.system.utils.JwtUtil;
import com.empl.system.utils.TokenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class TokenController {

    @Autowired private UserService userService;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody TokenRequest tokenRequest, HttpServletResponse response) throws Exception {

        authenticate(tokenRequest.getUsername(),tokenRequest.getPassword());

        final UserDetails user = userService.loadUserByUsername(tokenRequest.getUsername());

        if(user != null) {
            String token = jwtUtil.generateToken(user);
            AuthResponse authResponse = new AuthResponse();
            response.setHeader("token",token);
            authResponse.setToken(token);
            authResponse.setUsername(user.getUsername());

            authResponse.setExpiredInHr(jwtUtil.getExpirationDateFromToken(token).compareTo(new Date()));
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(HttpStatus.OK, authResponse, "", HttpStatus.OK.value()));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND,"","",HttpStatus.NOT_FOUND.value()));
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody AuthUser authUser){

        return userService.registerUser(authUser);
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e){
            throw new Exception("BAD_CREDENTIALs", e);
        }
    }
}
