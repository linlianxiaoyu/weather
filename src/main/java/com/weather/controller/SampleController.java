package com.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dell on 2017/8/23.
 */

@Controller
//@EnableAutoConfiguration
public class SampleController {

    private Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        logger.info("Home Controller Run");
        return "Hello World!";
    }

    @RequestMapping("/test")
    public ModelAndView test() {

        ModelAndView mav = new ModelAndView();

        mav.addObject("test","test");

        mav.setViewName("add");

        return mav;

    }
}