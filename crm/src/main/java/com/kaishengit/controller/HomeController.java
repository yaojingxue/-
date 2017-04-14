package com.kaishengit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Created by acer on 2017/4/13.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
        public String index() {
                return "login";
            }


                @RequestMapping("/home")
        public String home() {
                return "home";
            }
}
