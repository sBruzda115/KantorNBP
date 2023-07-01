package com.example.kantornbp.service;

import com.example.kantornbp.data.ExchangeResponse;
import com.example.kantornbp.data.NbpData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpApiService {

    public ExchangeResponse getCurrencyRate(String currency, Double pln_amount) {

        String url = "http://api.nbp.pl/api/exchangerates/rates/A/{code}?format=json";
        RestTemplate restTemplate = new RestTemplate();

        NbpData nbpData = restTemplate.getForObject(url, NbpData.class, currency);

        ExchangeResponse exchangeResponse = new ExchangeResponse();
        exchangeResponse.setCurrency(currency);
        exchangeResponse.setAmount(pln_amount / nbpData.getRates().get(0).getMid());

        return exchangeResponse;
    }


}
