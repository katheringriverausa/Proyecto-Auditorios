package com.usa.proyectoa.poyectoa.service;


import com.usa.proyectoa.poyectoa.entities.Reservation;
import com.usa.proyectoa.poyectoa.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation (id);
    }

    public Reservation save(Reservation m){
        if(m.getId()==null){
            return reservationRepository.save(m);
        }else {
            Optional<Reservation> e= reservationRepository.getReservation (m.getId());
            if(e.isPresent()){
                return e.get();
            }else{
                return reservationRepository.save(m);
            }
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation> a = reservationRepository.getReservation (id);
        if(a.isPresent()){
            reservationRepository.delete(a.get());
            flag = true;
        }
        return flag;
    }

}
