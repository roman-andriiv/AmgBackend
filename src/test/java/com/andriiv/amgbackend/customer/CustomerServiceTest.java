package com.andriiv.amgbackend.customer;

import com.andriiv.amgbackend.exception.DuplicateResourceException;
import com.andriiv.amgbackend.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

/**
 * Created by Roman Andriiv (12.08.2023 - 15:32)
 */
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    private CustomerService underTest;
    @Mock
    private CustomerDao customerDao;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerDao);
    }

    @Test
    void getAllCustomers() {
        //When
        underTest.getAllCustomers();
        //Then
        verify(customerDao).selectAllCustomers();
    }

    @Test
    void canGetCustomer() {
        //Given
        int id = 1;
        Customer customer = new Customer(id, "Roman", "roman.andriiv.dev@gmail.com", 27);
        when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(customer));

        //When
        Customer actual = underTest.getCustomer(id);
        //Then
        assertThat(actual).isEqualTo(customer);
    }

    @Test
    void getCustomer_willThrowException() {
        //Given
        int id = 1000;
        when(customerDao.selectCustomerById(id)).thenReturn(Optional.empty());
        //When
        //Then
        assertThatThrownBy(() -> underTest.getCustomer(id)).isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("customer with id [%s] not found".formatted(id));
    }

    @Test
    void addCustomer() {
        //Given
        String email = "roman.andriiv.dev@gmail.com";
        when(customerDao.existCustomerWithEmail(email)).thenReturn(false);
        CustomerRegistrationRequest request = new CustomerRegistrationRequest("Roman", email, 27);

        //When
        underTest.addCustomer(request);

        //Then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerDao).createCustomer(customerArgumentCaptor.capture());

        Customer cupturedCustomer = customerArgumentCaptor.getValue();

        assertThat(cupturedCustomer.getId()).isNull();
        assertThat(cupturedCustomer.getName()).isEqualTo(request.name());
        assertThat(cupturedCustomer.getEmail()).isEqualTo(request.email());
        assertThat(cupturedCustomer.getAge()).isEqualTo(request.age());
    }

    @Test
    void addCustomer_willThrowException_whenEmailExists() {
        //Given
        String email = "roman.andriiv.dev@gmail.com";
        when(customerDao.existCustomerWithEmail(email)).thenReturn(true);
        CustomerRegistrationRequest request = new CustomerRegistrationRequest("Roman", email, 27);

        //When
        assertThatThrownBy(() -> underTest.addCustomer(request)).isInstanceOf(DuplicateResourceException.class)
                .hasMessage("Email already exists");

        //Then
        verify(customerDao, never()).createCustomer(any());
    }

    @Test
    void deleteCustomer() {
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