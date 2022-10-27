package com.usa.proyectoa.poyectoa.service;

import com.usa.proyectoa.poyectoa.entities.Client;
import com.usa.proyectoa.poyectoa.entities.custom.CountClients;
import com.usa.proyectoa.poyectoa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient (int id){
        return clientRepository.getClient (id);
    }
    public Client save(Client a){
        if(a.getIdClient()==null){
            return clientRepository.save(a);
        }else {
            Optional<Client> e= clientRepository.getClient(a.getIdClient());
            if(e.isPresent()){
                return e.get();
            }else{
                return clientRepository.save(a);
            }
        }
    }

    public Client update(Client a){
        if(a.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(a.getIdClient());
            if(q.isPresent()){
                if(a.getName()!=null){
                    q.get().setName(a.getName());
                }
                if (a.getName()!=null){
                    q.get().setName(a.getName());
                }
                if (a.getEmail()!=null){
                    q.get().setEmail(a.getEmail());
                }
                if (a.getAge()!=null){
                    q.get().setAge(a.getAge());
                }
                if (a.getPassword()!=null){
                    q.get().setPassword(a.getPassword());
                }
                clientRepository.save(q.get());
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
        Optional<Client> a = clientRepository.getClient(id);
        if(a.isPresent()){
            clientRepository.delete(a.get());
            flag = true;
        }
        return flag;
    }


}
