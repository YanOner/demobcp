package com.bcp.prueba.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    private Integer id;
    private String name;
    private String code;
    private String symbol;

}
