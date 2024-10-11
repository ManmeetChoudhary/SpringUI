package com.example.client.UI.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.client.UI.entitiy.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {

    @GetMapping("/list")
    public String listCities(Model theModel) throws IOException {


        URL url = new URL("http://localhost:8090/api/cities");
        ObjectMapper mapper = new ObjectMapper();
        City[] myObjects = mapper.readValue(url, City[].class);
        List<City> cityList = Arrays.asList(myObjects);

        theModel.addAttribute("cities", cityList);

        return  "list-cities";

    }

    @GetMapping("/add")
    public String addCity(Model theModel){

        City city = new City();

        theModel.addAttribute("city", city);

        return  "add-cities";

    }

//    @PostMapping("/save")
//    public String addCity(@ModelAttribute("city") City city){
//
//        cityService.save(city);
//
//        return "redirect:/list";
//
//    }



}
