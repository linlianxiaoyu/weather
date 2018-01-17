package com.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell on 2017/8/23.
 */

@Controller
@EnableAutoConfiguration
public class SampleController {

    private Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping("/")
    @ResponseBody
    String home() {
        logger.info("Home Controller Run");
        return "Hello World!";
    }
}