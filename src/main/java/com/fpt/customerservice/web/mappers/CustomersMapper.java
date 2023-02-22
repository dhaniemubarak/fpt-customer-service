package com.fpt.customerservice.web.mappers;

import com.fpt.customerservice.domain.Customers;
import com.fpt.customerservice.web.model.CustomersDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomersMapper {
    CustomersDto customersToCustomersDto(Customers customers);

    Customers customersDtoToCustomers(CustomersDto customersDto);
}
