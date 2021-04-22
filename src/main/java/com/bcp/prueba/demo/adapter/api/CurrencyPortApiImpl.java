package com.bcp.prueba.demo.adapter.api;

import com.bcp.prueba.demo.config.ApplicationProperties;
import com.bcp.prueba.demo.domain.port.CurrencyPortApi;
import com.bcp.prueba.demo.entity.request.ExchangeRequest;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@Slf4j
public class CurrencyPortApiImpl implements CurrencyPortApi {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public Single<Double> rate(ExchangeRequest exchangeRequest) {
        return Single.fromCallable(() -> {
            RestTemplate restTemplate = new RestTemplate();

            String convert = exchangeRequest.getFrom() + "_" + exchangeRequest.getTo();

            String url
                    = applicationProperties.getUrlApiConvert()
                    + applicationProperties.getApiAccessKey()
                    + "&q=" + convert;

            log.info(url);

            Map<String, Double> response
                    = restTemplate.getForObject(url, Map.class);

            log.info(response.toString());

            return response.get(convert);
        });
    }
}
