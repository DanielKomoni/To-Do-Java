package com.ToDO.To.Do.App.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String userlogin(Model model){
        return "/login";
    }
    @GetMapping("/registration")
    public String userRegistration(Model model){
        return "/registration";
    }

    @GetMapping("/greeting")
    public String greeting(Model model)
    {return "/greeting";
    }
}



