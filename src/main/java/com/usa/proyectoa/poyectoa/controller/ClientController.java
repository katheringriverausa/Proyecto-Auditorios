package com.usa.proyectoa.poyectoa.controller;



import com.usa.proyectoa.poyectoa.entities.Client;
import com.usa.proyectoa.poyectoa.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @PostMapping ("/save")
    public Client save(@RequestBody Client a){
        return clientService.save(a);
    }
}
