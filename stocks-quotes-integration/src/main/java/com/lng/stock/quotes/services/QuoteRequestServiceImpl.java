package com.lng.stock.quotes.services;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author RajaniKantha Yammanuru
 *
 */
@Component
public class QuoteRequestServiceImpl implements QuoteRequestService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(QuoteRequestServiceImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String query = "select * from yahoo.finance.quotes where symbol in (%s)";
	
	@Value("${quotes.output.directory}")
	private String outputDirectory;
	
	@Value("${quotes.file.prefix}")
	private String prefix;

	@Override
	@ServiceActivator(inputChannel = "symbolQuoteRequestChannel", outputChannel = "quotesChannel")
	public String getQuote(String symbol) throws IOException {
		Resource resource = restTemplate.getForObject("http://download.finance.yahoo.com/d/quotes.csv?f=aa2bb2b3b4cc1c3c4c6c8dd1d2ee1e7e8e9ghjkg1g3g4g5g6ii5j1j3j4j5j6k1k2k4k5ll1l2l3mm2m3m4m5m6m7m8nn4opp1p2p5p6qrr1r2r5r6r7ss1s7t1t7t8vv1v7ww1w4xy&s={s}", Resource.class, symbol);
		String response = IOUtils.toString(resource.getInputStream());
		return response;
	}

}
