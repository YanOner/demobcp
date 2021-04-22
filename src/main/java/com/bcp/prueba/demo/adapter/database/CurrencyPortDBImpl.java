package com.bcp.prueba.demo.adapter.database;

import com.bcp.prueba.demo.adapter.database.model.ExchangeHistoryJPA;
import com.bcp.prueba.demo.adapter.database.repository.CurrencyRepository;
import com.bcp.prueba.demo.adapter.database.repository.ExchangeHistoryRepository;
import com.bcp.prueba.demo.domain.port.CurrencyPortDB;
import com.bcp.prueba.demo.entity.Currency;
import com.bcp.prueba.demo.entity.response.ExchangeResponse;
import io.reactivex.Flowable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

@Component
public class CurrencyPortDBImpl implements CurrencyPortDB {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private ExchangeHistoryRepository exchangeHistoryRepository;

    @Override
    public Flowable<Currency> getCurrencies() {
        return Flowable.fromIterable(
                currencyRepository.findAll().stream().map(currencyJPA -> {
                    Currency c = new Currency();
                    BeanUtils.copyProperties(currencyJPA, c);
                    return c;
                }).collect(Collectors.toList())
        );
    }

    @Override
    public void saveExchange(ExchangeResponse exchangeResponse) {
        ExchangeHistoryJPA exchangeHistoryJPA = new ExchangeHistoryJPA();
        BeanUtils.copyProperties(exchangeResponse, exchangeHistoryJPA);
        exchangeHistoryJPA.setAmountConvert(exchangeResponse.getAmountConvert().doubleValue());
        exchangeHistoryRepository.save(exchangeHistoryJPA);
    }

    @Override
    public Flowable<ExchangeResponse> getHistories() {
        return Flowable.fromIterable(
                exchangeHistoryRepository.findAll().stream().map(exchangeHistoryJPA -> {
                    ExchangeResponse exchangeResponse = new ExchangeResponse();
                    BeanUtils.copyProperties(exchangeHistoryJPA, exchangeResponse);
                    BigDecimal amountConvert = new BigDecimal(exchangeHistoryJPA.getAmountConvert());
                    amountConvert = amountConvert.setScale(4, RoundingMode.HALF_EVEN);
                    exchangeResponse.setAmountConvert(amountConvert);
                    return exchangeResponse;
                }).collect(Collectors.toList())
        );
    }

}
