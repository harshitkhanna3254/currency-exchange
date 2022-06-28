package com.hk.microservices.currencyexchangeservice.controller;

import com.hk.microservices.currencyexchangeservice.model.CurrencyExchangeModel;
import com.hk.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @Autowired
    private Environment environment;

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeModel retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchangeModel currencyExchangeModel = currencyExchangeService.retrieveExchangeRate(from, to);
        String currentPort = environment.getProperty("local.server.port");
        currencyExchangeModel.setEnvironment(currentPort);
        return currencyExchangeModel;
    }

}
