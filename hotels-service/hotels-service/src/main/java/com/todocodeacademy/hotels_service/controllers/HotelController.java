package com.todocodeacademy.hotels_service.controllers;

import com.todocodeacademy.hotels_service.models.Hotel;
import com.todocodeacademy.hotels_service.services.HotelService;
import com.todocodeacademy.hotels_service.services.IHotelService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @GetMapping("/{id_city}")
    public List<Hotel> getHotelsByCityId(@PathVariable Long id_city){

        return hotelService.getHotelsByCityId(id_city);
    }
}
