package com.wadzifa.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wadzifa.mvc.entity.Product;
import com.wadzifa.mvc.service.ProductService;

@Controller // RestController not for SpringMVC, cause Rest is return data, not layout
@RequestMapping("")
public class HomeController {
    
    @Autowired
    private ProductService service;

    @GetMapping
    public String welcome(Model model) {
        String message = "Welcome to Spring MVC with WR";
        model.addAttribute("msg", message);
        model.addAttribute("products", service.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        service.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, Model model) {
        service.updateProduct(product);
        return "redirect:/";
    }
}
