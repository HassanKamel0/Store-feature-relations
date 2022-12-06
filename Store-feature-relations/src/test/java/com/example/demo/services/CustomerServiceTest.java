package com.example.demo.services;
import com.example.demo.DTO.Response.CustomerResponse;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Tables.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
@Mock
private CustomerRepository customerRepository;
private  CartService cartService;
private CustomerResponse customerResponse;
@InjectMocks
private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest=new CustomerService(customerRepository,cartService);
    }

    @Test
    void getCustomer() {
        //given
        Customer customer=new Customer(100L,"Hasan","hassan@gmail.com","password");
        given(customerRepository.existsById(customer.getId())).willReturn(true);
        CustomerResponse response = new CustomerResponse();
        //when
        underTest.getCustomer(customer.getId());
    }

    @Test
    void postCustomer() {
    }

    @Test
    void deleteCustomer() {
        //given
        Customer customer=new Customer(100L,"Hasan","hassan@gmail.com","password");
        given(customerRepository.existsById(customer.getId())).willReturn(true);
        //when
        underTest.deleteCustomer(customer.getId());
        //then
        verify(customerRepository,times(1)).deleteById(customer.getId());
    }

    @Test
    void updateCustomer() {
    }
}