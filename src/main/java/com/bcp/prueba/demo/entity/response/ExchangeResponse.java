package com.bcp.prueba.demo.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeResponse {

    private String from;
    private String to;
    private Double amount;
    private Double rate;
    private BigDecimal amountConvert;
    private boolean status;

}
