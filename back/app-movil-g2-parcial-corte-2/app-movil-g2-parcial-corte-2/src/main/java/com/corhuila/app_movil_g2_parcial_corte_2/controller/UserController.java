package com.corhuila.app_movil_g2_parcial_corte_2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.app_movil_g2_parcial_corte_2.models.User;
import com.corhuila.app_movil_g2_parcial_corte_2.service.IUserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@RequestParam("id") Integer id) {
        return userService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam("id") Integer id) {
        userService.delete(id);
    }
    @PostMapping("/save")
    public User saveUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("role") String role, @RequestParam("phone") String phone) {
        User user = new User(name, email, password, role, phone);
        return userService.save(user);
    }
    @PutMapping("/update")
    public User updateUser(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("role") String role, @RequestParam("phone") String phone) {
        User user = new User(name, email, password, role, phone);
        return userService.update(id, user);
    }
}
