package com.usa.proyectoa.poyectoa.controller;

import com.usa.proyectoa.poyectoa.entities.Auditorium;
import com.usa.proyectoa.poyectoa.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auditorium")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @GetMapping("/all")
    public List<Auditorium> getAll(){
        return auditoriumService.getAll();
    }

    @PostMapping ("/save")
    public Auditorium save(@RequestBody Auditorium a){
        return auditoriumService.save(a);
    }
}
