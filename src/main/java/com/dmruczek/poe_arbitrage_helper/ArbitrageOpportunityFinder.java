package com.dmruczek.poe_arbitrage_helper;

import java.math.BigDecimal;
import java.util.List;

public class ArbitrageOpportunityFinder {

	public void outputOpportunities(List<CurrencyTradeListing> allListings) {

		for (int i = 1; i <= 39; i++) {
			if (i != 4) {
//				BigDecimal highestBuyRatio = new BigDecimal("-9999");
//				CurrencyTradeListing bestBuyOffer = null;
//				
//				BigDecimal lowestSellRatio = new BigDecimal("9999");
//				CurrencyTradeListing bestSellOffer = null;
//				
//				for (CurrencyTradeListing listing : allListings) {
//					if (listing.getBuyType() == i) {
//						BigDecimal thisRatio = listing.getBuyOffer().divide(listing.getSellOffer(), 5, BigDecimal.ROUND_HALF_UP);
//						if (thisRatio.compareTo(highestBuyRatio) > 0) {
//							highestBuyRatio = thisRatio;
//							bestBuyOffer = listing;
//						}
//					} else if (listing.getSellType() == i) {
//						 BigDecimal thisRatio = listing.getSellOffer().divide(listing.getBuyOffer(), 5, BigDecimal.ROUND_HALF_UP);
//						 if (thisRatio.compareTo(lowestSellRatio) < 0) {
//							 lowestSellRatio = thisRatio;
//							 bestSellOffer = listing;
//						 }
//					}
//				}

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
					printOpportunity(bestBuyOffer, bestSellOffer);
				}
			}
		}
		
	}
	

	protected void printOpportunity(CurrencyTradeListing buyListing, CurrencyTradeListing sellListing) {
		
		String currencyName = CurrencyTypeHelper.getCurrencyNameFromIdentifier(sellListing.getSellType());
		
		BigDecimal buyOfferForOneChaos = buyListing.getBuyOffer().divide(buyListing.getSellOffer(), 5, BigDecimal.ROUND_HALF_UP);
		BigDecimal sellOfferForOneChaos = sellListing.getSellOffer().divide(sellListing.getBuyOffer(), 5, BigDecimal.ROUND_HALF_UP);
		
		StringBuffer sb = new StringBuffer("Best arbitrage opportunity for ");
		sb.append(currencyName);
		sb.append(":\nOffer to buy at a rate of ");
		sb.append(buyListing.getBuyOffer());
		sb.append(" ");
		sb.append(currencyName);
		sb.append(" for ");
		sb.append(buyListing.getSellOffer());
		sb.append(" Chaos Orbs and offer to sell at a rate of ");
		sb.append(sellListing.getSellOffer());
		sb.append(" ");
		sb.append(currencyName);
		sb.append(" for ");
		sb.append(sellListing.getBuyOffer());
		sb.append(" Chaos Orbs.");
		sb.append("\nThis will get you around ");
		sb.append((buyOfferForOneChaos.subtract(sellOfferForOneChaos)).divide(buyOfferForOneChaos, 5, BigDecimal.ROUND_HALF_UP).toString());
		sb.append(" Chaos Orbs worth of currency per transaction.\n\n");
		
		System.out.println(sb.toString());
		
	}
	
	// Blacksmith's Whetstones: 
	// Offer to buy at a rate of 35 Blacksmith's Whetstones for 1 Chaos Orb and offer to sell at a rate of 25 Blacksmith's Whetstones for 1 Chaos Orb
	
	
}
