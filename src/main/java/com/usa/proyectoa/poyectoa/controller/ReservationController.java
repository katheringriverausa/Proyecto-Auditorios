package com.usa.proyectoa.poyectoa.controller;

import com.usa.proyectoa.poyectoa.entities.Reservation;

import com.usa.proyectoa.poyectoa.entities.custom.CountClients;
import com.usa.proyectoa.poyectoa.entities.custom.StatusAmount;
import com.usa.proyectoa.poyectoa.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation (id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation a){
        return reservationService.save(a);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation a){
        return reservationService.update (a);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete (id);
    }

    @GetMapping("report-status")
    public StatusAmount getReservationsStatus(){
        return reservationService.getStatusReport ();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDateReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2){
        return reservationService.getReservationsPeriod (d1, d2);
    }
    @GetMapping("/report-clients")
    public List<CountClients> getCountClients(){
        return reservationService.getTopCLients ();
    }
}

