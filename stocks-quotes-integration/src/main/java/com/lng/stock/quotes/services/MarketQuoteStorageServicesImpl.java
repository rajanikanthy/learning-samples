package com.lng.stock.quotes.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.lng.stock.quotes.cassandra.repositories.MarketQuoteRepository;
import com.lng.stock.quotes.domain.MarketQuote;

@Component
public class MarketQuoteStorageServicesImpl implements MarketQuoteStorageServices {
	
	@Autowired
	private MarketQuoteRepository marketRepository;

	@Override
	@ServiceActivator(inputChannel = "storageChannel")
	public void saveMarketQuotes(Collection<MarketQuote> quotes) {
		marketRepository.save(quotes);
	}

}
