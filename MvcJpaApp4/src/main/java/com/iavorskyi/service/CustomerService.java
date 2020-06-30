package com.iavorskyi.service;

import java.util.List;
import com.iavorskyi.entities.Customer;
import com.iavorskyi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component

public class CustomerService {
    final CustomerRepo repo;
    @Autowired
    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }
    @Transactional
    public void save(Customer customer) {
        repo.save(customer);
    }
    @Transactional
    public List<Customer> listAll() {
        return (List<Customer>) repo.findAll();
    }
    @Transactional
    public Customer get(Long id) {
        return repo.findById(id).get();
    }
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }

}