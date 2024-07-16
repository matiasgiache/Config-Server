package com.todocodeacademy.cities_service.services;

import com.todocodeacademy.cities_service.dtos.CityDTO;

public interface ICityService {

    public CityDTO getCitiesHotels(String name, String country);
}
