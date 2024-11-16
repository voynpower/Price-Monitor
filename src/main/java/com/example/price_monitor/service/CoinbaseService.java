package com.example.price_monitor.service;

import com.example.price_monitor.model.coinbase.SpotPriceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CoinbaseService {

    // TODO: 외부 API 를 호출하기 위한 RestClient 사용!
    private static final RestClient restClient = RestClient.create();

    public SpotPriceResponse getSpotPriceByCurrencyPair(String currencyPair) {
        return restClient
                .get()
                .uri("https://api.coinbase.com/v2/prices/BTC-USD/spot", currencyPair)
                .retrieve()
                .body(SpotPriceResponse.class);

    }
}
