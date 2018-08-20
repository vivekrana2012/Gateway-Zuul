package com.gatewayproject.repository;

import com.gatewayproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRoleRepository extends JpaRepository<Role, Long> {


}
