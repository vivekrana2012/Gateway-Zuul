package com.gatewayproject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        if(!"vivek".equals(username))
            throw new UsernameNotFoundException("No user present with username: "+username);
        else
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
                    auths.add(new SimpleGrantedAuthority("Admin"));
                    return auths;
                }

                @Override
                public String getPassword() {
                    return passwordEncoder.encode("vivek");
                }

                @Override
                public String getUsername() {
                    return "vivek";
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
            };
    }
}
