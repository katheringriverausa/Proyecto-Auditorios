package com.usa.proyectoa.poyectoa.controller;

import com.usa.proyectoa.poyectoa.entities.Category;
import com.usa.proyectoa.poyectoa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category>getCategory(@PathVariable("id") int id){
        return categoryService.getCategory (id);
    }

    @PostMapping ("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category a){
        return categoryService.save(a);
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category a){
        return categoryService.update (a);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return categoryService.delete (id);
    }
}
