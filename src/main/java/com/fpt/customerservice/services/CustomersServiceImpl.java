package com.fpt.customerservice.services;

import com.fpt.customerservice.domain.Customers;
import com.fpt.customerservice.repository.CustomersRepository;
import com.fpt.customerservice.web.exception.ForbiddenException;
import com.fpt.customerservice.web.exception.NotFoundException;
import com.fpt.customerservice.web.mappers.CustomersMapper;
import com.fpt.customerservice.web.model.CustomersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {


    private CustomersRepository customersRepository;

    private CustomersMapper customersMapper;

    @Autowired
    public void setCustomersMapper(CustomersMapper customersMapper) {
        this.customersMapper = customersMapper;
    }

    @Autowired
    public void setCustomersRepository(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public CustomersDto readCustomers(Integer custId) {
        Optional<Customers> fetchCustomer = customersRepository.findById(custId);
        if (fetchCustomer.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        Customers customers = fetchCustomer.get();
        return customersMapper.customersToCustomersDto(customers);
    }

    @Override
    public CustomersDto createCustomers(CustomersDto customersDto) {
        Customers customers = customersRepository.save(customersMapper.customersDtoToCustomers(customersDto));
        return customersMapper.customersToCustomersDto(customers);
    }

    @Override
    public CustomersDto updateCustomers(Integer custId, CustomersDto customersDto) {
        if (!custId.equals(customersDto.getCustId())) {
            throw new ForbiddenException("Customer id invalid");
        }
        Customers customers = customersRepository.save(customersMapper.customersDtoToCustomers(customersDto));
        return customersMapper.customersToCustomersDto(customers);
    }

    @Override
    public void deleteCustomers(Integer custId) {
        Optional<Customers> fetchCustomer = customersRepository.findById(custId);
        if (fetchCustomer.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        Customers customers = fetchCustomer.get();
        customersRepository.delete(customers);
    }
}
