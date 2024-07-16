package com.todocodeacademy.cities_service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private Long id_city;
    private String name,continent,country,state;
}
