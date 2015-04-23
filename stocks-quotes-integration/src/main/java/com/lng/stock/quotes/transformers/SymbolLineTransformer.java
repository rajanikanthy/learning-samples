package com.lng.stock.quotes.transformers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import com.lng.stock.quotes.entities.MarketSymbol;

/**
 * 
 * @author RajaniKantha Yammanuru
 *
 */
@Component
public class SymbolLineTransformer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SymbolLineTransformer.class);
	
	@Transformer(inputChannel = "symbolFileChannel", outputChannel = "symbolSplitterChannel")
	public Collection<MarketSymbol> splitMarketSymbols(File symbols) throws IOException {
		Collection<MarketSymbol> marketSymbols = new ArrayList<MarketSymbol>();
		LineIterator iterator = FileUtils.lineIterator(symbols);
		while(iterator.hasNext()) {
			String line = iterator.next();
			if ( line.startsWith("Symbol") || line.startsWith("File")) {
				continue;
			}
			MarketSymbol symbol = convertToMarketSymbol(line);
			marketSymbols.add(symbol);
		}
		LOGGER.info("Total market symbols : {}", marketSymbols.size());
		return marketSymbols;
	}
	
	private MarketSymbol convertToMarketSymbol(String marketSymbol) {
		String[] tokens = marketSymbol.split("\\|");
		MarketSymbol symbol = new MarketSymbol();
		symbol.setSymbol(tokens[0]);
		return symbol;
	}
}
