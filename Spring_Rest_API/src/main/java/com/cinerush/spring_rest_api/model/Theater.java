package com.cinerush.spring_rest_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theaters")
@Data
@NoArgsConstructor 
@AllArgsConstructor 
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theaterName;
    private String ownerName;
    private String email;
    private String phone;
    private String address;
    private String googleMapsLink;
    private int numberOfScreens;
    private int seatingCapacityPerScreen;
}


