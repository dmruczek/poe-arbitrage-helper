package com.dmruczek.poe_arbitrage_helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArbitrageOpportunityFinder {

	public void outputOpportunities(List<CurrencyTradeListing> allListings) {

		List<ArbitrageOpportunity> allOpportunities = new ArrayList<ArbitrageOpportunity>();
		
		for (int i = 1; i <= 39; i++) {
			if (i != 4) {

				BigDecimal lowestBuyRatio = new BigDecimal("9999");
				CurrencyTradeListing bestBuyOffer = null;
				
				BigDecimal highestSellRatio = new BigDecimal("-9999");
				CurrencyTradeListing bestSellOffer = null;
				
				for (CurrencyTradeListing listing : allListings) {
					if (listing.getBuyType() == i) {
						BigDecimal thisRatio = listing.getBuyOffer().divide(listing.getSellOffer(), 5, BigDecimal.ROUND_HALF_UP);
						if (thisRatio.compareTo(lowestBuyRatio) < 0) {
							lowestBuyRatio = thisRatio;
							bestBuyOffer = listing;
						}
					} else if (listing.getSellType() == i) {
						 BigDecimal thisRatio = listing.getSellOffer().divide(listing.getBuyOffer(), 5, BigDecimal.ROUND_HALF_UP);
						 if (thisRatio.compareTo(highestSellRatio) > 0) {
							 highestSellRatio = thisRatio;
							 bestSellOffer = listing;
						 }
					}
				}
				
				if (bestBuyOffer != null && bestSellOffer != null) {
					ArbitrageOpportunity opportunity = new ArbitrageOpportunity();
					opportunity.setBuyListing(bestBuyOffer);
					opportunity.setSellListing(bestSellOffer);
					allOpportunities.add(opportunity);
				} else if (bestBuyOffer != null) {
					String currency = CurrencyTypeHelper.getCurrencyNameFromIdentifier(i);
					System.out.println("Nobody is currently selling " + currency + " for Chaos Orbs, but you can buy " + bestBuyOffer.getSellOffer() + " Chaos Orbs for " + bestBuyOffer.getBuyOffer() + " " + currency + ".");
				} else if (bestSellOffer != null) {
					// I'm certain this is wrongly phrased.  Need test data.
					String currency = CurrencyTypeHelper.getCurrencyNameFromIdentifier(i);
					System.out.println("Nobody is currently buying " + currency + ".  Best exising sell offer is " + bestSellOffer.getBuyOffer() + " " + currency + " for " + bestSellOffer.getSellOffer() + " Chaos Orbs.");
				} else {
					// both null.
					System.out.println("Nobody buying or selling " + CurrencyTypeHelper.getCurrencyNameFromIdentifier(i));
					
				}
			}
		}
		
		Collections.sort(allOpportunities);
		
		for (ArbitrageOpportunity opportunity : allOpportunities) {
			System.out.println(opportunity.toString());
		}
		
	}
	
}
