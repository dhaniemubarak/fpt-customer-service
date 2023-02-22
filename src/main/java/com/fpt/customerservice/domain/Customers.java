package com.fpt.customerservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer custId;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String custName;

    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String custAddress;
}
