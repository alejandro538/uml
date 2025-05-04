package com.corhuila.corte_2_parcial_2.service;

import java.util.List;
import java.util.Optional;

import com.corhuila.corte_2_parcial_2.models.Reserva;

public interface IReservaService {

    List<Reserva> listarReservas();
    Optional<Reserva> obtenerReserva(Integer id);
    Reserva saveReserva(Reserva reserva);
    void deleteReserva(Integer id);
    Reserva updateReserva(Integer id,Reserva reserva);

    
}
