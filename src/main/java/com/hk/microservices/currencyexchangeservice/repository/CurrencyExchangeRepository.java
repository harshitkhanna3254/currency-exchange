package com.hk.microservices.currencyexchangeservice.repository;

import com.hk.microservices.currencyexchangeservice.model.CurrencyExchangeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeModel, Long> {

    Optional<CurrencyExchangeModel> findByFromAndTo(String from, String to);

}
