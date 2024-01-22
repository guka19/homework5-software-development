package ge.ibsu.demo.services;

import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long cityId) {
        Optional<City> optionalCity = cityRepository.findById(cityId);
        return optionalCity.orElse(null);
    }
}
