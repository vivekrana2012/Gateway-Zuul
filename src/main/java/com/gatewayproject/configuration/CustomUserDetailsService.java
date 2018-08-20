package com.gatewayproject.configuration;

import com.gatewayproject.model.User;
import com.gatewayproject.model.User_Role;
import com.gatewayproject.repository.CustomUserRepository;
import com.gatewayproject.repository.CustomUserRoleRepository;
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
    private CustomUserRepository userRepository;

    @Autowired
    private CustomUserRoleRepository customUserRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private List<User_Role> user_roles;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(!user.getUsername().equals(username))
            throw new UsernameNotFoundException("No user present with username: "+username);
        else

            user_roles = customUserRoleRepository.findByEmailId(user.getEmail_id());

            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
                    for(int counter = 0; counter < user_roles.size(); counter++){
                        auths.add(new SimpleGrantedAuthority(user_roles.get(counter).getRole_name()));
                    }
                    return auths;
                }

                @Override
                public String getPassword() {
                    return passwordEncoder.encode(user.getPassword());
                }

                @Override
                public String getUsername() {
                    return user.getUsername();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return user.isIs_active();
                }

                @Override
                public boolean isAccountNonLocked() {
                    return user.isIs_active();
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return user.isIs_active();
                }

                @Override
                public boolean isEnabled() {
                    return user.isIs_active();
                }
            };
    }
}
