package com.example.springOne;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    @Value("${spring.application.name}")
    private String appName;
    @RequestMapping("/")
    public String index() {
        System.out.println(appName);
        return "forward:/index.html";
    }
}
