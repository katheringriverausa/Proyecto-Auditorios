package com.usa.proyectoa.poyectoa.controller;

import com.usa.proyectoa.poyectoa.entities.Auditorium;
import com.usa.proyectoa.poyectoa.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Audience")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @GetMapping("/all")
    public List<Auditorium> getAll(){
        return auditoriumService.getAll();
    }

    @PostMapping ("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorium save(@RequestBody Auditorium a){
        return auditoriumService.save(a);
    }

    @GetMapping("/{id}")
    public Optional<Auditorium>getAuditorium(@PathVariable("id") int id){
        return auditoriumService.getAuditorium (id);
    }
    @PutMapping("/update")
    public Auditorium update(@RequestBody Auditorium a){
        return auditoriumService.update (a);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return auditoriumService.delete (id);
    }

}
