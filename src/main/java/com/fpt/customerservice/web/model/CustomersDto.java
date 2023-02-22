package com.fpt.customerservice.web.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomersDto {

    private Integer custId;

    @NotNull
    private String custName;

    @NotNull
    private String custAddress;

}
