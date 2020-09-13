package com.li.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestIndex {


    @GetMapping("/")
    public String inext(){
        return "blog";
    }
}
