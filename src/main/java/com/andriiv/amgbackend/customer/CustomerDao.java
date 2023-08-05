package com.andriiv.amgbackend.customer;

import java.util.List;
import java.util.Optional;

/**
 * Created by Roman Andriiv (05.08.2023 - 09:09)
 */

public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
}
