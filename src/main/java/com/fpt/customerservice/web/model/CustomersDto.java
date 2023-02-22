package com.fpt.customerservice.web.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomersDto {

    private Integer custId;

    @NotNull
    private String custName;

    @NotNull
    private String custAddress;

}
