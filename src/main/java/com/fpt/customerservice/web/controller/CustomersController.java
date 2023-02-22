package com.fpt.customerservice.web.controller;

import com.fpt.customerservice.services.CustomersService;
import com.fpt.customerservice.web.model.CustomersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomersController {

    private CustomersService customersService;

    @Autowired
    public void setCustomersService(CustomersService customersService) {
        this.customersService = customersService;
    }

    @PostMapping
    public ResponseEntity<CustomersDto> create(@RequestBody CustomersDto customersDto) {
        CustomersDto resultCustomerDto = customersService.createCustomers(customersDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(UriComponentsBuilder.fromPath("/api/v1/customers/{id}")
                .buildAndExpand(resultCustomerDto.getCustId()).toUri());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomersDto> read(@PathVariable("id") Integer custId) {
        return new ResponseEntity<>(customersService.readCustomers(custId), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomersDto> update(@PathVariable("id") Integer custId, @RequestBody CustomersDto customersDto) {
        return new ResponseEntity<>(customersService.updateCustomers(custId, customersDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer custId) {
        customersService.deleteCustomers(custId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
