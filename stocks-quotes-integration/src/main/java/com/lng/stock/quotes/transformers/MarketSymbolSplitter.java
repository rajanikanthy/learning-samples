package com.lng.stock.quotes.transformers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.lng.stock.quotes.entities.MarketSymbol;

@Component
public class MarketSymbolSplitter {
	
	@Value("${quotes.batch.size}")
	private Integer batchSize;
	
	@Splitter(inputChannel = "symbolSplitterChannel", outputChannel = "symbolQuoteRequestChannel") 
	public Collection<String> splitMarketSymbols(Collection<MarketSymbol> marketSymbols) {
		Collection<String> symbolStr = new ArrayList<String>();
		for(List<MarketSymbol> syms : Lists.partition(new ArrayList<MarketSymbol>(marketSymbols), batchSize)) {
			List<String> symbolsList = new ArrayList<String>();
			for(MarketSymbol sym : syms) {
				symbolsList.add(sym.getSymbol());
			}
			String[] ss = new String[symbolStr.size()];
			ss = symbolsList.toArray(ss);
			symbolStr.add(StringUtils.join(ss, ","));
		}
		return symbolStr;
	}
}
