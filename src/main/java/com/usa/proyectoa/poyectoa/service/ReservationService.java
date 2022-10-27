package com.usa.proyectoa.poyectoa.service;

import com.usa.proyectoa.poyectoa.entities.Client;
import com.usa.proyectoa.poyectoa.entities.Reservation;
import com.usa.proyectoa.poyectoa.entities.custom.CountClients;
import com.usa.proyectoa.poyectoa.entities.custom.StatusAmount;
import com.usa.proyectoa.poyectoa.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        if(m.getIdReservation ()==null){
            return reservationRepository.save(m);
        }else {
            Optional<Reservation> e= reservationRepository.getReservation (m.getIdReservation ());
            if(e.isPresent()){
                return e.get();
            }else{
                m.setStatus ("non-created");
                return reservationRepository.save(m);
            }
        }
    }

    public Reservation update(Reservation a){
        if(a.getIdReservation ()!=null){
            Optional<Reservation> q = reservationRepository.getReservation (a.getIdReservation ());
            if(q.isPresent()){
                if(a.getStartDate ()!=null){
                    q.get().setStartDate (a.getStartDate ());
                }
                if(a.getDevolutionDate ()!=null){
                    q.get().setDevolutionDate (a.getDevolutionDate ());
                }
                if(a.getStatus ()!=null){
                    q.get().setStatus (a.getStatus ());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return a;
            }
        }else{
            return a;
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

    public StatusAmount getStatusReport(){
        List<Reservation> completed=reservationRepository.getReservationsByStatus ("completed");
        List<Reservation> cancelled=reservationRepository.getReservationsByStatus ("cancelled");

        StatusAmount sttAmt=new StatusAmount (completed.size (), cancelled.size ());
        return sttAmt;
    }

    public List<Reservation> getReservationsPeriod(String d1, String d2){

        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date dateOne=new Date ();
        Date dateTwo=new Date ();
        try{
            dateOne=parser.parse (d1);
            dateTwo=parser.parse (d2);
        }catch (ParseException e){
            e.printStackTrace ();
        }
        if (dateOne.before (dateTwo)){
            return reservationRepository.getReservationsByPeriod (dateOne, dateTwo);
        }else {
            return new ArrayList<> ();
        }

    }

    public List<CountClients> getTopCLients(){
        return reservationRepository.getTopClients ();
    }

}
