package com.gatewayproject.repository;

import com.gatewayproject.model.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomUserRoleRepository extends JpaRepository<User_Role, Long> {

    public List<User_Role> findByEmailId(String emailId);
}
