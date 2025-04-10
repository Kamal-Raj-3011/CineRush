package com.cinerush.app.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class AdminController {

    @GetMapping("/admin/login")
    public String adminlogin() {
        return "admin/adminlogin"; 
    }

    @GetMapping("/admindashboard")
    public String adminDashboard() {
        return "admin/admindashboard";
    }

    @GetMapping("/admintheaters")
    public String adminTheater() {
        return "admin/admintheaters";
    }

    @GetMapping("/adminmovies")
    public String adminMovies() {
        return "admin/adminmovies";
    }

    @GetMapping("/adminanalytics")
    public String adminAnalytics() {
        return "admin/adminanalytics";
    }

    @GetMapping("/adminsettings")
    public String adminSettings() {
        return "admin/adminsettings";
    }

}

