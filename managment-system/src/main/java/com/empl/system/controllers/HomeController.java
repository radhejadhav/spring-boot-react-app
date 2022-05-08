package com.empl.system.controllers;

import com.empl.system.entities.AuthUser;
import com.empl.system.services.PagingUserService;
import com.empl.system.services.UserService;
import com.empl.system.utils.ApiResponse;
import com.empl.system.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HomeController {

    @Autowired UserService userService;

    @Autowired private PagingUserService pagingUserService;

    @Autowired JwtUtil jwtUtil;

    @GetMapping("/home")
    public String welcome(){
        return "Welcome Home";
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(HttpServletRequest request){
        String token = request.getHeader("Authorization").substring(7);
        String username = jwtUtil.getUsernameFromToken(token);
        try {
            AuthUser authUser = (AuthUser) userService.loadUserByUsername(username);
            if(authUser != null){
                return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK,authUser,"",HttpStatus.OK.value()));
            }
            return ResponseEntity.notFound().build();
        }catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getPage(@RequestParam Integer page, @RequestParam Integer size){
        Page<AuthUser> userPage = pagingUserService.getPage(page,size);

        return ResponseEntity.ok(userPage);
    }
}
