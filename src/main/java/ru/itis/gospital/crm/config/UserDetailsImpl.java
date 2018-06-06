package ru.itis.gospital.crm.config;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.gospital.crm.models.User;


import java.util.Collection;
import java.util.Collections;


@Getter
public class UserDetailsImpl implements UserDetails {

    //менять здесь
    private User user;

    //менять здесь
    public UserDetailsImpl(User user) {
        this.user = user;
        }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
        return Collections.singletonList(authority);
    }

    //менять здесь
    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }

    //менять здесь
    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
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
