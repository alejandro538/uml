




package com.corhuila.exposicion.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin(origins = "*")
public class SaludoController {
    @GetMapping("/saludo")
    public String saludo() {
        return "Hola Mundo";
    }

}