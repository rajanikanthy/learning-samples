package com.lng.stock.quotes.cassandra.repositories;

import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.stereotype.Repository;

import com.lng.stock.quotes.domain.MarketQuote;
import com.lng.stock.quotes.domain.MarketQuoteKey;

@Repository
public interface MarketQuoteRepository extends
		TypedIdCassandraRepository<MarketQuote, MarketQuoteKey> {

}
