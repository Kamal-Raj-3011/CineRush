package com.cinerush.app.spring_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.cinerush.app.spring_mvc.model.Theater;


@Controller
public class AdminController {

    @Autowired
    private RestTemplate restTemplate; // Inject RestTemplate for API calls

    private final String REST_API_URL = "http://localhost:8091/api/theaters"; // REST API endpoint for theaters

    @GetMapping("/admin/login")
    public String adminlogin() {
        return "admin/adminlogin"; 
    }

    @GetMapping("/admindashboard")
    public String adminDashboard() {
        return "superadmin/admindashboard";
    }

    // Display all theaters
    @GetMapping("/admintheaters")
    public String getAllTheaters(Model model) {
        // Fetching all theaters from the REST API
        Theater[] theaters = restTemplate.getForObject(REST_API_URL, Theater[].class); // Array of theaters
        model.addAttribute("theaters", theaters); // Add the list of theaters to the model
        return "superadmin/admintheaters"; // Thymeleaf template to display all theaters
    }


    @GetMapping("/adminmovies")
    public String adminMovies() {
        return "superadmin/adminmovies";
    }

    @GetMapping("/adminanalytics")
    public String adminAnalytics() {
        return "superadmin/adminanalytics";
    }

    @GetMapping("/adminsettings")
    public String adminSettings() {
        return "superadmin/adminsettings";
    }

}

