package com.bcp.prueba.demo.domain.port;

import com.bcp.prueba.demo.entity.Currency;
import com.bcp.prueba.demo.entity.response.ExchangeResponse;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface CurrencyPortDB {

    Flowable<Currency> getCurrencies();

    void saveExchange(ExchangeResponse exchangeResponse);

    Flowable<ExchangeResponse> getHistories();

    Single<Boolean> validateUser(String username, String password);
}
