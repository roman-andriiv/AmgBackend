package com.andriiv.amgbackend.customer;

import com.andriiv.amgbackend.AbstractTestcontainers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by Roman Andriiv (09.08.2023 - 19:20)
 */

class CustomerJDBCDataAccessServiceTest extends AbstractTestcontainers {
    private final CustomerRowMapper customerRowMapper = new CustomerRowMapper();
    private CustomerJDBCDataAccessService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerJDBCDataAccessService(getJdbcTemplate(), customerRowMapper);
    }

    @Test
    void selectAllCustomers() {
        //Given

        //When

        //Then
    }

    @Test
    void selectCustomerById() {
        //Given

        //When

        //Then
    }

    @Test
    void createCustomer() {
        //Given

        //When

        //Then
    }

    @Test
    void existCustomerWithEmail() {
        //Given

        //When

        //Then
    }

    @Test
    void existCustomerWithId() {
        //Given

        //When

        //Then
    }

    @Test
    void deleteCustomerById() {
        //Given

        //When

        //Then
    }

    @Test
    void updateCustomer() {
        //Given

        //When

        //Then
    }
}