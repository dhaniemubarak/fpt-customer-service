package com.fpt.customerservice.web.model;


import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String custName;

    @NotNull
    @NotBlank
    private String custAddress;

}
