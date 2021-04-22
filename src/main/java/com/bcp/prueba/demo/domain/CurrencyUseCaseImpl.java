package com.bcp.prueba.demo.domain;

import com.bcp.prueba.demo.domain.port.CurrencyPortApi;
import com.bcp.prueba.demo.domain.port.CurrencyPortDB;
import com.bcp.prueba.demo.entity.Currency;
import com.bcp.prueba.demo.entity.request.ExchangeRequest;
import com.bcp.prueba.demo.entity.response.ExchangeResponse;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
public class CurrencyUseCaseImpl implements CurrencyUseCase {

    @Autowired
    private CurrencyPortDB currencyPortDB;

    @Autowired
    private CurrencyPortApi currencyPortApi;

    @Override
    public Flowable<Currency> getCurrencies() {
        return currencyPortDB.getCurrencies();
    }

    @Override
    public Single<ExchangeResponse> exchange(ExchangeRequest exchangeRequest) {
        return currencyPortApi.rate(exchangeRequest).map(rate -> {
            BigDecimal amountConvert = new BigDecimal(rate * exchangeRequest.getAmount());
            amountConvert = amountConvert.setScale(4, RoundingMode.HALF_EVEN);
            ExchangeResponse exchangeResponse = ExchangeResponse.builder()
                    .from(exchangeRequest.getFrom())
                    .to(exchangeRequest.getTo())
                    .amount(exchangeRequest.getAmount())
                    .rate(rate)
                    .amountConvert(amountConvert)
                    .status(true)
                    .creationDatetime(LocalDateTime.now())
                    .build();
            currencyPortDB.saveExchange(exchangeResponse);
            return exchangeResponse;
        });
    }

    @Override
    public Flowable<ExchangeResponse> getHistories() {
        return currencyPortDB.getHistories();
    }

}
