package com.cinerush.app.spring_mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.cinerush.app.spring_mvc.model.User;



@Controller
public class UserController {

     @Autowired
    private RestTemplate restTemplate; // Inject RestTemplate

    private final String REST_API_URL = "http://localhost:8091/api/users/";

    @GetMapping("/{id}")
    public String getUserProfile(@PathVariable Long id, Model model) {
        String url = REST_API_URL + id;
        User user = restTemplate.getForObject(url, User.class);
        model.addAttribute("user", user);
        return "userprofile"; // Thymeleaf template
    }

    @GetMapping("/")
    public String getHome() {
        return "user/index";
    }
    

    @GetMapping("/theater")
    public String getCinemas() {
        return "user/theater";
    }
    
    @GetMapping("/cinema")
    public String getMovieTime() {
        return "user/cinema";
    }

    @GetMapping("/seat")
    public String getSeat() {
        return "user/seat";
    }

    @GetMapping("/aboutus")
    public String aboutUs() {
        return "user/aboutus";
    }

    @GetMapping("/movietimings")
    public String movieTimings() {
        return "user/movietimings";
    }

    @GetMapping("/contactus")
    public String contactUs() {
        return "user/contactus";
    }

}


