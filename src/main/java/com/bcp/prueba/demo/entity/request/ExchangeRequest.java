package com.bcp.prueba.demo.entity.request;

import lombok.Data;

@Data
public class ExchangeRequest {

    private String from;
    private String to;
    private Double amount;

}
