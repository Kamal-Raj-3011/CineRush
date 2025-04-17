package com.cinerush.spring_rest_api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinerush.spring_rest_api.model.Theater;
import com.cinerush.spring_rest_api.repository.TheaterRepository;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    // Method to create a new theater
    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    // Method to retrieve all theaters
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    // Method to retrieve a theater by its ID
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id).orElseThrow(() -> new RuntimeException("Theater not found"));
    }

    // Method to delete a theater
    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
