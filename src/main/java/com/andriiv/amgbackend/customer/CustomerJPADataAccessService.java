package com.andriiv.amgbackend.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Roman Andriiv (05.08.2023 - 09:41)
 */
@Repository("jpa")
public class CustomerJPADataAccessService implements CustomerDao {
    private final CustomerRepository customerRepository;

    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customerRepository.findById(id);
    }
}
