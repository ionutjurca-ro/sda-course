package com.sda.spring.boot.mvc.security.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true) // nullable nu va crea unu gol
    private String username;

    @Column(nullable = false)
    private String password;

    private int active;

    // ADMINE, MANAGER, WRITE
    private String roles = "";
    private String permissions = "";

    protected AppUser() {
    }

    public AppUser(String username, String password, String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    // helper methods, because roles will be strings
    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(", "));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(", "));
        }
        return new ArrayList<>();
    }
}
