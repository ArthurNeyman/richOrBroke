package com.ArthurNeyman.testTaskForAlfaBank.client;

import com.ArthurNeyman.testTaskForAlfaBank.domain.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-api-client", url = "${currency-api-client.url}")
public interface CurrencyServiceClient {

    @GetMapping(value = "/{date}.json?app_id=${currency-api-client.app_id}")
    Currency getCurrency(@PathVariable String date);

}
