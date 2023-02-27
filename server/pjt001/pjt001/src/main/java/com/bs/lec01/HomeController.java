package com.bs.lec01;

import java.util.HashMap;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

	   // home.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
	
	
}
