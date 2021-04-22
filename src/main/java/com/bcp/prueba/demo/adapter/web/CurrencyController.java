package com.bcp.prueba.demo.adapter.web;

import com.bcp.prueba.demo.domain.CurrencyUseCase;
import com.bcp.prueba.demo.entity.Currency;
import com.bcp.prueba.demo.entity.request.ExchangeRequest;
import com.bcp.prueba.demo.entity.response.ExchangeResponse;
import io.reactivex.Flowable;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {
    @Autowired
    private CurrencyUseCase currencyUseCase;

    @GetMapping("")
    public Flowable<Currency> getCurrencies() {
        return currencyUseCase.getCurrencies();
    }

    @GetMapping("/exchange")
    public Single<ExchangeResponse> exchange(ExchangeRequest exchangeRequest) {
        return currencyUseCase.exchange(exchangeRequest)
                .onErrorReturnItem(ExchangeResponse.builder().status(false).build());
    }

    @GetMapping("/history")
    public Flowable<ExchangeResponse> getHistories() {
        return currencyUseCase.getHistories();
    }

}
