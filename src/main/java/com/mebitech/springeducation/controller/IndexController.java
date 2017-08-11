package com.mebitech.springeducation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by alicankustemur on 10/08/2017.
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.addObject("myname","BUSRA");

        modelAndView.addObject("date",new Date());

        modelAndView.setViewName("index");
        return modelAndView;
    }

}
