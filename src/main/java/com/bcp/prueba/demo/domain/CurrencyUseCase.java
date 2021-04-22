package com.bcp.prueba.demo.domain;

import com.bcp.prueba.demo.entity.Currency;
import com.bcp.prueba.demo.entity.request.ExchangeRequest;
import com.bcp.prueba.demo.entity.response.ExchangeResponse;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface CurrencyUseCase {

    Flowable<Currency> getCurrencies();

    Single<ExchangeResponse> exchange(ExchangeRequest exchangeRequest);

    Flowable<ExchangeResponse> getHistories();

}
