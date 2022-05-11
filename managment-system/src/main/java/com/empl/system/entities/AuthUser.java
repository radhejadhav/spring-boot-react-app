package com.empl.system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class AuthUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String mobile;

    private String displayName;

    private String firstName;

    private String lastName;

    private String company;

    private String password;

    private String username;

    private boolean enabled;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<UserRole> roles;

    public AuthUser() {
        UserRole role = new UserRole();
        Collection<UserRole> userRoles = new ArrayList<>();
        role.setName("USER");
        userRoles.add(role);

        this.enabled = true;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.roles = userRoles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
//    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public Collection<UserRole> getRoles() {
        return this.roles;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<UserRole> roles = getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(UserRole role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
