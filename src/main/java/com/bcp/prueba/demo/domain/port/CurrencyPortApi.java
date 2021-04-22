package com.bcp.prueba.demo.domain.port;

import com.bcp.prueba.demo.entity.request.ExchangeRequest;
import io.reactivex.Single;

public interface CurrencyPortApi {

    Single<Double> rate(ExchangeRequest exchangeRequest);

}
