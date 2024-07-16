package com.todocodeacademy.cities_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private Long id,id_city;
    private String name;
    private int stars;
}
