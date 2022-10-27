package com.usa.proyectoa.poyectoa.repository;

import com.usa.proyectoa.poyectoa.entities.Auditorium;
import com.usa.proyectoa.poyectoa.repository.crudRepository.AuditoriumCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuditoriumRepository {

    @Autowired
    private AuditoriumCrudRepository auditoriumCrudRepository;

    public List<Auditorium> getAll(){
        return (List<Auditorium>)auditoriumCrudRepository.findAll();
    }

    public Auditorium save(Auditorium a){
        return auditoriumCrudRepository.save(a);
    }

    public Optional<Auditorium> getAuditorium(int id){
        return auditoriumCrudRepository.findById(id);
    }

    public void delete(Auditorium a){
        auditoriumCrudRepository.delete(a);
    }


}
