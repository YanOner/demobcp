package com.bcp.prueba.demo.adapter.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchange_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeHistoryJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency", nullable = false)
    private String from;

    @Column(name = "to_currency", nullable = false)
    private String to;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @Column(name = "amount_convert", nullable = false)
    private Double amountConvert;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "creation_datetime", nullable = false)
    private LocalDateTime creationDatetime;

}
