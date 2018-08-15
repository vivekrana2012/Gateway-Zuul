package com.gatewayproject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    public User(User user){
        this.user_id = user.getUser_id();
        this.username = user.getUsername();
        this.email_id = user.getEmail_id();
        this.password = user.getPassword();
        this.active = user.getActive();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long user_id;
    @Column(name = "username")
    private String username;
    @Column(name = "email_id")
    private String email_id;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private int active;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
