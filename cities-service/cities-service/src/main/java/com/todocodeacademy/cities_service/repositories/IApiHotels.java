package com.todocodeacademy.cities_service.repositories;

import com.todocodeacademy.cities_service.dtos.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-service")
public interface IApiHotels {
    @GetMapping("/hotels/{id_city}")
    public List<HotelDTO> getHotelsByCityId(@PathVariable("id_city") Long id_city);
}
