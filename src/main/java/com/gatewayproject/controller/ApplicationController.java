package com.gatewayproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

@Controller
public class ApplicationController {

    @RequestMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/home")
    public String home(HttpSession session){
        return "home.html";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("logging out");
        session.invalidate();
        return "login.html";}
}
