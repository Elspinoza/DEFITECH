package com.defitech.tpVente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlleur {

    @GetMapping("/home")
    public String getHome(){
        return "design/index";
    }
}
