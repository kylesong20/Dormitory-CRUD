package com.kyle.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther kyle
 * @creat 2022-07-22:44
 */
@Controller
public class Welcome {
    @RequestMapping("/")
    public String welcome(){
        return "index";
    }
}
