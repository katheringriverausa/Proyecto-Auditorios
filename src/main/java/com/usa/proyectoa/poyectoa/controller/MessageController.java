package com.usa.proyectoa.poyectoa.controller;


import com.usa.proyectoa.poyectoa.entities.Message;
import com.usa.proyectoa.poyectoa.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @PostMapping("/save")
    public Message save(@RequestBody Message a){
        return messageService.save(a);
    }

}
