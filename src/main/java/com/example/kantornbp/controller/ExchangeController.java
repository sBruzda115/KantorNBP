package com.example.kantornbp.controller;

import com.example.kantornbp.data.ExchangeResponse;
import com.example.kantornbp.service.NbpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("convertCurrency")
public class ExchangeController {


    private final NbpApiService service;
    private ExchangeResponse exchangeResponse;

    @Autowired
    public ExchangeController(NbpApiService service) {
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<ExchangeResponse> getExchangeData(@RequestParam(required = false) String currency,
                                                            @RequestParam(required = false) Double pln_amount) {

            exchangeResponse = service.getCurrencyRate(currency, pln_amount);

        return ResponseEntity.ok(exchangeResponse);
    }

}



