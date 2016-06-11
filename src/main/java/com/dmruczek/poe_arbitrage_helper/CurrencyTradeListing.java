package com.dmruczek.poe_arbitrage_helper;

import java.math.BigDecimal;

public class CurrencyTradeListing {

	private BigDecimal sellOffer;
	private BigDecimal buyOffer;

	private int sellType;
	private int buyType;

	public BigDecimal getSellOffer() {
		return sellOffer;
	}

	public void setSellOffer(BigDecimal sellOffer) {
		this.sellOffer = sellOffer;
	}

	public BigDecimal getBuyOffer() {
		return buyOffer;
	}

	public void setBuyOffer(BigDecimal buyOffer) {
		this.buyOffer = buyOffer;
	}

	public int getSellType() {
		return sellType;
	}

	public void setSellType(int sellType) {
		this.sellType = sellType;
	}

	public int getBuyType() {
		return buyType;
	}

	public void setBuyType(int buyType) {
		this.buyType = buyType;
	}

}
