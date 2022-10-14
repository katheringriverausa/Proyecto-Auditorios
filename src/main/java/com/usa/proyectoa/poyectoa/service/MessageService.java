package com.usa.proyectoa.poyectoa.service;

import com.usa.proyectoa.poyectoa.entities.Message;
import com.usa.proyectoa.poyectoa.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message m){
        if(m.getIdMessage ()==null){
            return messageRepository.save(m);
        }else {
            Optional<Message> e= messageRepository.getMessage(m.getIdMessage ());
            if(e.isPresent()){
                return e.get();
            }else{
                return messageRepository.save(m);
            }
        }
    }
    public Message update(Message a){
        if(a.getIdMessage ()!=null){
            Optional<Message> q = messageRepository.getMessage (a.getIdMessage());
            if(q.isPresent()){
                if(a.getMessageText ()!=null){
                    q.get().setMessageText(a.getMessageText ());
                }
                messageRepository.save(q.get());
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
        Optional<Message> a = messageRepository.getMessage(id);
        if(a.isPresent()){
            messageRepository.delete(a.get());
            flag = true;
        }
        return flag;
    }

}
