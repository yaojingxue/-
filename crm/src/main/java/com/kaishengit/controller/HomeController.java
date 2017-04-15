package com.kaishengit.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by acer on 2017/4/13.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "login";
    }


    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String login(String username, String password,RedirectAttributes redirectAttributes) {
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            subject.login(usernamePasswordToken);
            return "redirect:/home";
        }catch( LockedAccountException e){
            redirectAttributes.addFlashAttribute("message","账户已被禁用！");
            return "redirect:/";
        }
        catch (AuthenticationException e) {
            redirectAttributes.addFlashAttribute("message","用户名或密码错误！");
            return "redirect:/";
        }

    }
    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
