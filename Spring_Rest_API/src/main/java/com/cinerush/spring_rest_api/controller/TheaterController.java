package com.cinerush.spring_rest_api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cinerush.spring_rest_api.model.Theater;
import com.cinerush.spring_rest_api.service.TheaterService;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@CrossOrigin(origins = "http://localhost:8090") // Allow requests from the frontend application
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    // Endpoint to create a new theater
    @PostMapping
    public ResponseEntity<Theater> createTheater(@RequestBody Theater theater) {
        Theater createdTheater = theaterService.createTheater(theater);
        return new ResponseEntity<>(createdTheater, HttpStatus.CREATED);
    }

    // Endpoint to get all theaters
    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheaters() {
        List<Theater> theaters = theaterService.getAllTheaters();
        return new ResponseEntity<>(theaters, HttpStatus.OK);
    }

    // Endpoint to get a specific theater by ID
    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        Theater theater = theaterService.getTheaterById(id);
        return new ResponseEntity<>(theater, HttpStatus.OK);
    }

    // Endpoint to delete a theater by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

