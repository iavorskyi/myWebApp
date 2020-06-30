package com.iavorskyi.controllers;

import com.iavorskyi.entities.Customer;
import com.iavorskyi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FirstController {
    @Autowired
    public CustomerService customerService;


    @GetMapping("/list")
    public String customerList(){
        return "list";
    }

    @GetMapping("/customlist")
    public ModelAndView home() {
        List<Customer> listCustomer = customerService.listAll();
        ModelAndView mav = new ModelAndView("customerList");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }

    @RequestMapping("/new")
    public String newCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new";
    }
}
