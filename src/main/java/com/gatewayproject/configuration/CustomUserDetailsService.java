package com.gatewayproject.configuration;

import com.gatewayproject.model.User;
import com.gatewayproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = new User();
        user.setActive(0);
        user.setEmail_id("");
        user.setPassword("vivek");
        user.setUser_id(1);
        user.setUsername("vivek");

        if(null == user)
            throw new UsernameNotFoundException("No user present with username: "+username);
        else
            return new CustomUserDetails(user, Arrays.asList("user"));
    }
}
