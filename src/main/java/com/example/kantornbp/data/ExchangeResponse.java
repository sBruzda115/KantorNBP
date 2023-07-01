package com.example.kantornbp.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class ExchangeResponse {
    @JsonProperty("currency")
    private static String currency;
    @JsonProperty("amount")
    private static Double amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {return String.format("%.2f", amount);}

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
