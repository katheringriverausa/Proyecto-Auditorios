package com.usa.proyectoa.poyectoa.repository;
import com.usa.proyectoa.poyectoa.entities.Client;
import com.usa.proyectoa.poyectoa.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll (){
        return (List<Client>) clientCrudRepository.findAll ();
    }

    public Client save (Client c){
        return clientCrudRepository.save (c);
    }

    public Optional<Client> getClient (int id){

        return clientCrudRepository.findById (id);
    }

    public void delete (Client c){
        clientCrudRepository.delete (c);
    }
}


