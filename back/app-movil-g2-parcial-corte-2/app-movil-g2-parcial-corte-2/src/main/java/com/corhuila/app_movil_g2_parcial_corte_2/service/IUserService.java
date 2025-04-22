package com.corhuila.app_movil_g2_parcial_corte_2.service;

import java.util.List;
import java.util.Optional;

import com.corhuila.app_movil_g2_parcial_corte_2.models.User;

public interface IUserService {

    List<User> findAll();
    Optional<User> findById(Integer id);    
     User save (User user );
    User update ( Integer id, User user);
    void delete(Integer id);
    
}
