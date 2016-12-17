package com.dmruczek.poe_arbitrage_helper;

import java.math.BigDecimal;

public class ArbitrageOpportunity implements Comparable<ArbitrageOpportunity> {

	private CurrencyTradeListing buyListing;
	private CurrencyTradeListing sellListing;

	public CurrencyTradeListing getBuyListing() {
		return buyListing;
	}

	public void setBuyListing(CurrencyTradeListing buyListing) {
		this.buyListing = buyListing;
	}

	public CurrencyTradeListing getSellListing() {
		return sellListing;
	}

	public void setSellListing(CurrencyTradeListing sellListing) {
		this.sellListing = sellListing;
	}

	public BigDecimal calculateOpportunityValue() {
		BigDecimal buyOfferForOneChaos = buyListing.getBuyOffer().divide(buyListing.getSellOffer(), 5, BigDecimal.ROUND_HALF_UP);
		BigDecimal sellOfferForOneChaos = sellListing.getSellOffer().divide(sellListing.getBuyOffer(), 5, BigDecimal.ROUND_HALF_UP);
		return (buyOfferForOneChaos.subtract(sellOfferForOneChaos)).divide(buyOfferForOneChaos, 5, BigDecimal.ROUND_HALF_UP);
	}

	public int compareTo(ArbitrageOpportunity o) {
		return this.calculateOpportunityValue().compareTo(o.calculateOpportunityValue());
	}

	@Override
	public String toString() {

		String currencyName = CurrencyTypeHelper.getCurrencyNameFromIdentifier(sellListing.getSellType());
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
		sb.append(calculateOpportunityValue());
		sb.append(" Chaos Orbs worth of return per Chaos Orb risked.\n\n");

		return sb.toString();
	}
	// Blacksmith's Whetstones: 
	// Offer to buy at a rate of 35 Blacksmith's Whetstones for 1 Chaos Orb and offer to sell at a rate of 25 Blacksmith's Whetstones for 1 Chaos Orb

	
}
