package com.lng.stock.quotes.services;

import java.io.IOException;

/**
 * 
 * @author RajaniKantha Yammanuru
 *
 */

public interface QuoteRequestService {
	String getQuote(String symbol) throws IOException;
}
