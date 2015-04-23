package com.lng.stock.quotes.transformers;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.lng.stock.quotes.domain.MarketQuote;

public class MarketQuoteTransformerTest {
	@Test
	public void testTransform() throws Exception {
		Resource resource = new ClassPathResource("/stock-test.csv");
		MarketQuoteTransformer transformer = new MarketQuoteTransformer();
		Collection<MarketQuote> quotes = transformer.transform(resource.getFile());
		Assert.assertNotNull(quotes);
	}
}
