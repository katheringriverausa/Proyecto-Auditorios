package com.usa.proyectoa.poyectoa.service;


import com.usa.proyectoa.poyectoa.entities.Category;

import com.usa.proyectoa.poyectoa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getAuditorium(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category a){
        if(a.getId()==null){
            return categoryRepository.save(a);
        }else {
            Optional<Category> e= categoryRepository.getCategory(a.getId());
            if(e.isPresent()){
                return e.get();
            }else{
                return categoryRepository.save(a);
            }
        }
    }

    public Category update(Category a){
        if(a.getId()!=null){
            Optional<Category> q = categoryRepository.getCategory(a.getId());
            if(q.isPresent()){
                if(a.getName()!=null){
                    q.get().setName(a.getName());
                }
                if (a.getName()!=null){
                    q.get().setName(a.getName());
                }
                if (a.getDescription()!=null){
                    q.get().setDescription(a.getDescription());
                }
                categoryRepository.save(q.get());
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
        Optional<Category> a = categoryRepository.getCategory(id);
        if(a.isPresent()){
            categoryRepository.delete(a.get());
            flag = true;
        }
        return flag;
    }

}
