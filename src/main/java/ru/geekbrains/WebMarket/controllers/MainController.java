package ru.geekbrains.WebMarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // GET > http://localhost:8189/market/products
    @GetMapping()
    public String showIndexPage(){
        return "index";
    }
}
