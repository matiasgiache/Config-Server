package com.todocodeacademy.cities_service.services;

import com.todocodeacademy.cities_service.dtos.CityDTO;
import com.todocodeacademy.cities_service.models.City;
import com.todocodeacademy.cities_service.repositories.IApiHotels;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{

    @Autowired
    private IApiHotels apiHotels;
    List<City> cities = new ArrayList<>();

    @Override
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "GetCitiesHotelsFallBack")
    @Retry(name = "hotels-service")
    public CityDTO getCitiesHotels(String name, String country) {

        City city = this.findCity(name,country);

        CityDTO cityDTO = new CityDTO();

        cityDTO.setId_city(city.getId_city());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setState(city.getState());

        cityDTO.setHotelList(apiHotels.getHotelsByCityId(city.getId_city()));

        //createException();

        return cityDTO;
    }
    public City findCity(String name, String country) {
        this.loadCities();
        for (City c:cities) {
            if (c.getName().equals(name)) {
                if (c.getCountry().equals(country)) {
                    return c;
                }
            }
        }
        return null;
    }
    public void loadCities () {

        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City(13L, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15L, "Valencia", "Europe", "Spain", "Valencian Community"));

    }

    public CityDTO GetCitiesHotelsFallBack(String name, String country,Throwable throwable){
        return new CityDTO(9999999L,"Fallido","Fallido",
                "Fallido","Fallido",null);
    }

    public void createException(){
        throw new IllegalArgumentException("Prueba Resilience4j y Circuit Breaker");
    }
}
