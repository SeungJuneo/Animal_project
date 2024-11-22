package com.example.demo.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping("/")
    public String mainPage() {
        return "animal/animal";
    }

    @GetMapping("/missing")
    public String missing(){
        return "missing/missing";
    }

}
