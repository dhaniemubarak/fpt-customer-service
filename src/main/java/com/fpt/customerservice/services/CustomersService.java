package com.fpt.customerservice.services;

import com.fpt.customerservice.web.model.CustomersDto;

public interface CustomersService {
    CustomersDto readCustomers(Integer custId);

    CustomersDto createCustomers(CustomersDto customersDto);

    CustomersDto updateCustomers(Integer custId, CustomersDto customersDto);

    void deleteCustomers(Integer custId);
}
