package com.corhuila.app_movil_g2_parcial_corte_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corhuila.app_movil_g2_parcial_corte_2.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    
}
