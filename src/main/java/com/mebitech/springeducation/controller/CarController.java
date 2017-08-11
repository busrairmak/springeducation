package com.mebitech.springeducation.controller;

import com.mebitech.springeducation.ColorEnum;
import com.mebitech.springeducation.dao.CarDao;
import com.mebitech.springeducation.domain.Car;
import com.mebitech.springeducation.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alicankustemur on 11/08/2017.
 */

@Controller
@RequestMapping(value = "/car", method = RequestMethod.GET)
public class CarController {

    @Autowired
    private CarService carService;

    private final static String CAR_PAGE = "redirect:/car";
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.addObject("car",new Car());
        modelAndView.addObject("cars",carService.getAll());
        modelAndView.setViewName("car");
        return modelAndView;
    }


    @RequestMapping(value = "addCar", method = RequestMethod.POST)
    public String addCar(@ModelAttribute Car car){

        carService.create(car);
        return CAR_PAGE;
    }
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    public String deleteCar(@PathVariable Long id){
        carService.remove(id);
        return CAR_PAGE;
    }
    @RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
    public ModelAndView editCar(@PathVariable Long id,ModelAndView modelAndView){
        Car car=carService.get(id);
        modelAndView.addObject("car",car);
        modelAndView.setViewName("car");
        modelAndView.addObject("cars",carService.getAll());
        return modelAndView;

    }
    @RequestMapping(value ="updateCar/{id}",method = RequestMethod.POST)
    public String updateCar(@PathVariable Long id,@ModelAttribute Car car){
        carService.edit(id,car);
        return CAR_PAGE;
    }


}
