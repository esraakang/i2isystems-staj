package com.example.swagger.service;

import com.example.swagger.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    private final Map<Long, CustomerDTO> customerMap = new HashMap<>();
    private long currentId = 1;

    public CustomerDTO createCustomer(CustomerDTO customer) {
        customer.setId(currentId++);
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public CustomerDTO getCustomerById(Long id) {
        return customerMap.get(id);
    }

    public List<CustomerDTO> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customer) {
        if (!customerMap.containsKey(id)) return null;
        customer.setId(id);
        customerMap.put(id, customer);
        return customer;
    }

    public boolean deleteCustomer(Long id) {
        return customerMap.remove(id) != null;
    }
}
