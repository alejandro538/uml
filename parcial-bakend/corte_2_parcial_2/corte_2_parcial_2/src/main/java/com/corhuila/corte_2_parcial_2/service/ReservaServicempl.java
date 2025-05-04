package com.corhuila.corte_2_parcial_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corte_2_parcial_2.models.Reserva;
import com.corhuila.corte_2_parcial_2.repository.ReservaRepository;
@Service
public class ReservaServicempl implements IReservaService {
@Autowired
private ReservaRepository repository;
    @Override
    public List<Reserva> listarReservas() {
       return repository.findAll();
    }

    @Override
    public Optional<Reserva> obtenerReserva(Integer id) {
       return repository.findById(id);
    }

    @Override
    public Reserva saveReserva(Reserva reserva) {
       return repository.save(reserva);
    }

    @Override
    public void deleteReserva(Integer id) {
         repository.deleteById(id);
    }

    


    @Override
    public Reserva updateReserva(Integer id, Reserva reserva) {
        Optional<Reserva> up = repository.findById(id);
        if (up.isPresent()) {
            
            Reserva reservaacual = up.get();
            reservaacual.setNombre(reserva.getNombre());
            reservaacual.setDireccion(reserva.getDireccion());
            reservaacual.setTelefono(reserva.getTelefono());
            reservaacual.setEmail(reserva.getEmail());            
            return repository.save(reservaacual);
        } else {
            System.out.println("No se encontró la reserva");
             return null;
        }
    }}
