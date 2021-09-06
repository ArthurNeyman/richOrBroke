package com.ArthurNeyman.testTaskForAlfaBank.controller;

import com.ArthurNeyman.testTaskForAlfaBank.service.CurrencyService;
import com.ArthurNeyman.testTaskForAlfaBank.service.GifService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Locale;

@RestController
@RequestMapping("currency")
public class Controller {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private GifService gifService;

    @GetMapping(value = "/{currencyCode}", produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<byte[]> getStatus(@PathVariable String currencyCode){

        try {
            boolean isIncrease = currencyService.isCurrencyIncrease(currencyCode.toUpperCase(Locale.ROOT));
            return new ResponseEntity<>(gifService.getGif(isIncrease), HttpStatus.OK);
        }catch (NullPointerException nullPointerException){
            return new ResponseEntity<>(new byte[]{}, HttpStatus.NOT_FOUND);
        }catch (FeignException | IOException feignException){
                return new ResponseEntity<>(new byte[]{}, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
