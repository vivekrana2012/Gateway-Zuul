package com.gatewayproject.repository;

import com.gatewayproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomUserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

}
