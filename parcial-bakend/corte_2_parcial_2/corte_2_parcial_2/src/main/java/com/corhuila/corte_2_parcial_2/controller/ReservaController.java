package com.corhuila.corte_2_parcial_2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.corte_2_parcial_2.models.Reserva;
import com.corhuila.corte_2_parcial_2.service.IReservaService;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {
    @Autowired
    IReservaService reservaService;

    @GetMapping("/all")
    public List<Reserva> getAllUsers() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> getUserById(@RequestParam("id") Integer id) {
        return reservaService.obtenerReserva(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam("id") Integer id) {
        reservaService.deleteReserva(id);
    }
    @PutMapping("/update")
    public Reserva updatReserva (@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("role") String role, @RequestParam("phone") String phone) {
        User user = new User(name, email, password, role, phone);
        return userService.update(id, user);
    
}}
