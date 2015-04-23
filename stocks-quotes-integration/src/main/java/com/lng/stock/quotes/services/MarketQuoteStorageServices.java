package com.lng.stock.quotes.services;

import java.util.Collection;

import com.lng.stock.quotes.domain.MarketQuote;

public interface MarketQuoteStorageServices {
	void saveMarketQuotes(Collection<MarketQuote> quotes);
}
