package com.usa.proyectoa.poyectoa.repository;

import com.usa.proyectoa.poyectoa.entities.Client;
import com.usa.proyectoa.poyectoa.entities.Reservation;
import com.usa.proyectoa.poyectoa.entities.custom.CountClients;
import com.usa.proyectoa.poyectoa.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){

        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Reservation save(Reservation m){
        return reservationCrudRepository.save(m);
    }

    public Optional<Reservation> getReservation(int id){

        return reservationCrudRepository.findById(id);
    }

    public void delete(Reservation m){
        reservationCrudRepository.delete(m);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationsByPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore (dateOne, dateTwo);
    }
    public List<CountClients> getTopClients(){
        List<CountClients> res=new ArrayList<> ();

        List<Object[]> report=reservationCrudRepository.countReservationByClient ();
        for (int i=0; i<report.size ();i++){
            res.add (new CountClients ((Long) report.get (i)[1], (Client) report.get (i)[0]));
        }

        return res;
    }
}
