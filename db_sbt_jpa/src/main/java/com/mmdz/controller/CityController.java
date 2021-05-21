package com.mmdz.controller;

import com.mmdz.entity.City;
import com.mmdz.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author: MMDZ
 * @Date: 2021/5/21
 * @Desc:
 */
@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(value = "saveCity")
    public String saveCity(String cityName,String cityIntroduce){
        City city = new City(cityName,cityIntroduce);
        cityRepository.save(city);
        return "success";
    }

    @GetMapping(value = "deleteCity")
    public String deleteCity(int cityId){
        cityRepository.deleteById(cityId);
        return "success";
    }

    @GetMapping(value = "updateCity")
    public String updateCity(int cityId,String cityName,String cityIntroduce){
        City city = new City(cityId,cityName,cityIntroduce);
        cityRepository.save(city);
        return "success";
    }

    @GetMapping(value = "getCityById")
    public City getCityById(int cityId){
        City city = cityRepository.getById(cityId);
        return city;
    }

}
