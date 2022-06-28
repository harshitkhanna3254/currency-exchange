package com.hk.microservices.currencyexchangeservice.service;

import com.hk.microservices.currencyexchangeservice.model.CurrencyExchangeModel;
import com.hk.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeModel retrieveExchangeRate(String from, String to) {

        Optional<CurrencyExchangeModel> currencyExchangeOptional = currencyExchangeRepository.findByFromAndTo(from, to);

        if (currencyExchangeOptional.isEmpty())
            throw new RuntimeException("Empty dataset");

        return currencyExchangeOptional.get();
    }

}
