package com.fpt.customerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.customerservice.services.CustomersService;
import com.fpt.customerservice.web.model.CustomersDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

@WebMvcTest(CustomersController.class)
class CustomersControllerTest {

    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Autowired
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @MockBean
    CustomersService customersService;

    @Test
    void create() throws Exception {
        CustomersDto customersDto = CustomersDto.builder()
                .custId(1)
                .custName("FPT User Created")
                .custAddress("Indonesia").build();
        String customers = objectMapper.writeValueAsString(customersDto);
        given(customersService.createCustomers(any())).willReturn(customersDto);
        mockMvc.perform(post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customers))
                .andExpect(status().isCreated());
    }

    @Test
    void read() throws Exception {
        mockMvc.perform(get("/api/v1/customers/1")).andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(put("/api/v1/customers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CustomersDto.builder()
                                .custId(1)
                                .custName("FPT User")
                                .custAddress("Indonesia").build())))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCustomer() throws Exception {
        mockMvc.perform(delete("/api/v1/customers/1")).andExpect(status().isNoContent());
    }
}