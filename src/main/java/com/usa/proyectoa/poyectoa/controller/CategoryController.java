package com.usa.proyectoa.poyectoa.controller;


import com.usa.proyectoa.poyectoa.entities.Category;
import com.usa.proyectoa.poyectoa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping ("/save")
    public Category save(@RequestBody Category a){
        return categoryService.save(a);
    }
}
