package com.ArthurNeyman.testTaskForAlfaBank.service;

import com.ArthurNeyman.testTaskForAlfaBank.client.CurrencyServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.function.Function;

@Service
public class CurrencyService {

    @Autowired
    CurrencyServiceClient currencyServiceClient;

    @Value("${currency-api-client.typeCurrencyTo}")
    String currentCurrency;

    public boolean isCurrencyIncrease(String currencyType) throws NullPointerException {

        Function<LocalDate, String> getStrFromDate = (date) ->
                date.getYear() + "-" +
                        (date.getMonth().getValue() > 10 ? date.getMonth().getValue() : "0" + date.getMonth().getValue()) + "-" +
                        (date.getDayOfMonth() > 10 ? date.getDayOfMonth() : "0" + date.getDayOfMonth());

        String dateToday = getStrFromDate.apply(LocalDate.now());
        String dateYesterday = getStrFromDate.apply(LocalDate.now().minusDays(1));

        float yesterday = currencyServiceClient.getCurrency(dateYesterday).getRates().get(currencyType)
                / currencyServiceClient.getCurrency(dateToday).getRates().get(currentCurrency);

        float today = currencyServiceClient.getCurrency(dateToday).getRates().get(currencyType)
                / currencyServiceClient.getCurrency(dateToday).getRates().get(currentCurrency);

        return yesterday - today > 0;
    }

}
