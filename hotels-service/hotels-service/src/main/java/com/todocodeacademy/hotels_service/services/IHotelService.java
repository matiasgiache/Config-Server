package com.todocodeacademy.hotels_service.services;

import com.todocodeacademy.hotels_service.models.Hotel;

import java.util.List;

public interface IHotelService {

    public List<Hotel> getHotelsByCityId(Long id_city);
}
