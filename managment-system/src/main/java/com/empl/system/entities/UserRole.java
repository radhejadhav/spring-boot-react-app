package com.empl.system.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
//@Table(name = "users_roles")
public class UserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Collection<AuthUser> users;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilage> privileges;

    public UserRole() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Collection<AuthUser> getUsers() {
        return users;
    }

    public void setUsers(Collection<AuthUser> users) {
        this.users = users;
    }

    @JsonIgnore
    public Collection<Privilage> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilage> privileges) {
        this.privileges = privileges;
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return privileges.stream().collect(Collectors.toList()).toString();
    }
}
