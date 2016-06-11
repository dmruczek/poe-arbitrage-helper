package com.dmruczek.poe_arbitrage_helper;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	
	protected static CurrencyRateDataRetriever currencyRateDataRetriever = new CurrencyRateDataRetriever();
	protected static ArbitrageOpportunityFinder arbitrageOpportunityFinder = new ArbitrageOpportunityFinder();

	
	public static void main(String[] args) {
		List<CurrencyTradeListing> listings = currencyRateDataRetriever.retrieveAllCurrencyRates();
		arbitrageOpportunityFinder.outputOpportunities(listings);
	}
}
