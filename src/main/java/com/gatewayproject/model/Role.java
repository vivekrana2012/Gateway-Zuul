package com.gatewayproject.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long role_id;

    @Column(name = "role_name")
    private String role_name;
}
