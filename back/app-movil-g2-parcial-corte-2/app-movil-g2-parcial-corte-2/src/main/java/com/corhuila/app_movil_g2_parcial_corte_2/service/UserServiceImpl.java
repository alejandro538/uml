package com.corhuila.app_movil_g2_parcial_corte_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.app_movil_g2_parcial_corte_2.models.User;
import com.corhuila.app_movil_g2_parcial_corte_2.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(Integer id) {  // Corrected typo here from "delate" to "delete"
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return repository.findById(id);
    }   

    @Override
    public User update(Integer id, User user) {
        Optional<User> up = repository.findById(id);
        if (up.isPresent()) {
            User usuarioactual = up.get();
            usuarioactual.setName(user.getName());
            usuarioactual.setEmail(user.getEmail());
            usuarioactual.setPassword(user.getPassword());
            usuarioactual.setRole(user.getRole());
            usuarioactual.setPhone(user.getPhone());
            return repository.save(usuarioactual);
        } else {
            System.out.println("No se encontró el usuario");
            return null;
        }
    }
}
