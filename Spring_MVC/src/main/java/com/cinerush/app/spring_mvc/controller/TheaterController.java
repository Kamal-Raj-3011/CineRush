package com.cinerush.app.spring_mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cinerush.app.spring_mvc.model.Theater;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;


@Controller
public class TheaterController {

    @Autowired
    private RestTemplate restTemplate;

    private final String API_URL = "http://localhost:8091/api/theaters"; // The SpringRestApi URL

    @PostMapping("/contactus")
    public String registerTheater(
        @RequestParam String theaterName,
        @RequestParam String ownerName,
        @RequestParam String email,
        @RequestParam String phoneNumber,
        @RequestParam String address,
        @RequestParam String googleMapsLink,
        @RequestParam int numberOfScreens,
        @RequestParam int avgSeatingCapacity,
        Model model
    ) {
        // Create a new Theater object
        Theater newTheater = new Theater();
        newTheater.setTheaterName(theaterName);
        newTheater.setOwnerName(ownerName);
        newTheater.setEmail(email);
        newTheater.setPhone(phoneNumber);
        newTheater.setAddress(address);
        newTheater.setGoogleMapsLink(googleMapsLink);
        newTheater.setNumberOfScreens(numberOfScreens);
        newTheater.setSeatingCapacityPerScreen(avgSeatingCapacity);

        try {
            // Send the data to the backend using RestTemplate
            ResponseEntity<Theater> response = restTemplate.exchange(
                API_URL, HttpMethod.POST, new HttpEntity<>(newTheater), Theater.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                // On successful registration, show a success message in the model
                model.addAttribute("message", "Theater registered successfully!");
            } else {
                model.addAttribute("message", "Failed to register theater. Please try again.");
            }
        } catch (Exception e) {
            model.addAttribute("message", "An error occurred: " + e.getMessage());
        }

        // Return the contactus page with the success/failure message
        return "user/contactus";
    }
}

