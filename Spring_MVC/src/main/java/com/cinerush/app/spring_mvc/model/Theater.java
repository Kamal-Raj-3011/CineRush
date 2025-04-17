package com.cinerush.app.spring_mvc.model;

import lombok.Data;

@Data
public class Theater {

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

