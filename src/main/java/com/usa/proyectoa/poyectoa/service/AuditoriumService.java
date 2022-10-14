package com.usa.proyectoa.poyectoa.service;

import com.usa.proyectoa.poyectoa.entities.Auditorium;
import com.usa.proyectoa.poyectoa.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public List<Auditorium> getAll(){
        return auditoriumRepository.getAll();
    }

    public Optional<Auditorium> getAuditorium(int id){
        return auditoriumRepository.getAuditorium(id);
    }

    public Auditorium save(Auditorium a){
        if(a.getId()==null){
            return auditoriumRepository.save(a);
        }else {
            Optional<Auditorium> e= auditoriumRepository.getAuditorium(a.getId());
            if(e.isPresent()){
                return e.get();
            }else{
                return auditoriumRepository.save(a);
            }
        }
    }

    public Auditorium update(Auditorium a){
        if(a.getId()!=null){
            Optional<Auditorium> q = auditoriumRepository.getAuditorium(a.getId());
            if(q.isPresent()){
                if(a.getName()!=null){
                    q.get().setName(a.getName());
                }
                if (a.getOwner()!=null){
                    q.get().setOwner(a.getOwner());
                }
                if (a.getCapacity()!=null){
                    q.get().setCapacity(a.getCapacity());
                }
                if (a.getCategory()!=null){
                    q.get().setCategory(a.getCategory());
                }
                if (a.getDescription ()!=null){
                    q.get().setDescription (a.getDescription ());
                }
                auditoriumRepository.save(q.get());
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
        Optional<Auditorium> a = auditoriumRepository.getAuditorium(id);
        if(a.isPresent()){
            auditoriumRepository.delete(a.get());
            flag = true;
        }
        return flag;
    }

}
