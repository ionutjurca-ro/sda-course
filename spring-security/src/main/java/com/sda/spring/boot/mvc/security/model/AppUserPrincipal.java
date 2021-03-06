package com.sda.spring.boot.mvc.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserPrincipal implements UserDetails {

    // create principal out of an application user

    // decorator pattern
    private AppUser appUser;

    public AppUserPrincipal(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // add authorities and roles to app user principal
        List<GrantedAuthority> authorities = new ArrayList<>();

        // extract roles from app user (ROLE_name)
        this.appUser.getRoleList().forEach(role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            authorities.add(authority);
        });

        // extract permissions from app user (name)
        this.appUser.getPermissionList().forEach(permission -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(permission);
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
