package com.lng.stock.quotes.transformers;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import com.lng.stock.quotes.cassandra.repositories.MarketQuoteRepository;
import com.lng.stock.quotes.domain.Field;
import com.lng.stock.quotes.domain.MarketQuote;
import com.lng.stock.quotes.domain.MarketQuoteKey;

@Component
public class MarketQuoteTransformer {
	private static final Logger LOGGER = LoggerFactory.getLogger(MarketQuoteTransformer.class);
	
	@Autowired
	private MarketQuoteRepository marketQuoteRepository;
	
	@Transformer(inputChannel = "quotesInboundChannel", outputChannel = "inputToKafka")
	public Collection<MarketQuote> transform(File file) throws Exception {
		LOGGER.info("Parsing file : {}", file.getAbsoluteFile());
		Collection<MarketQuote> marketQuotes = new ArrayList<MarketQuote>();
		LineIterator lineIterator = FileUtils.lineIterator(file);
		while (lineIterator.hasNext()) {
			MarketQuote quote = new MarketQuote();
			quote.setMarketQuoteKey(new MarketQuoteKey());
			quote.getMarketQuoteKey().setUuid(UUID.randomUUID().toString());
			quote.setCreatedTime(Calendar.getInstance().getTime());
			String marketQuote = lineIterator.next();
			String[] splitFields = marketQuote.split(",");
			for(int i = 0; i < splitFields.length - 1 ; i++) {
				Field field = Field.getFieldByIndex(i + 1);
				if (field != null) {
					if (field.getFieldName().equals("symbol")) {
						quote.getMarketQuoteKey().setSymbol(splitFields[i].replaceAll("\"", "").trim());
					} else {
						PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(MarketQuote.class, field.getFieldName());
						pd.getWriteMethod().invoke(quote, new Object[]{ splitFields[i].replaceAll("\"", "").trim()});
					}
				} else {
					LOGGER.error("No field found for line {}", marketQuote);
					LOGGER.error("And index {}", i);
				}
			}
			marketQuotes.add(quote);
			FileUtils.deleteQuietly(file);
		}
		return marketQuotes;
	}
}
