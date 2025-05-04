package com.corhuila.corte_2_parcial_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corhuila.corte_2_parcial_2.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    
}
