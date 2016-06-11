package com.dmruczek.poe_arbitrage_helper;

import java.util.HashMap;
import java.util.Map;

public class CurrencyTypeHelper {
	
	private static Map<Integer,String> identifierToCurrencyNameMap;
	
	static {
		identifierToCurrencyNameMap = new HashMap<Integer, String>();
		identifierToCurrencyNameMap.put(1, "Orb of Alteration");
		identifierToCurrencyNameMap.put(2, "Orb of Fusing");
		identifierToCurrencyNameMap.put(3, "Orb of Alchemy");
		identifierToCurrencyNameMap.put(4, "Chaos Orb");
		identifierToCurrencyNameMap.put(5, "Gemcutter's Prism");
		identifierToCurrencyNameMap.put(6, "Exalted Orb");
		identifierToCurrencyNameMap.put(7, "Chromatic Orb");
		identifierToCurrencyNameMap.put(8, "Jeweler's Orb");
		identifierToCurrencyNameMap.put(9, "Orb of Chance");
		identifierToCurrencyNameMap.put(10, "Cartographer's Chisel");
		identifierToCurrencyNameMap.put(11, "Orb of Scouring");
		identifierToCurrencyNameMap.put(12, "Blessed Orb");
		identifierToCurrencyNameMap.put(13, "Orb of Regret");
		identifierToCurrencyNameMap.put(14, "Regal Orb");
		identifierToCurrencyNameMap.put(15, "Divine Orb");
		identifierToCurrencyNameMap.put(16, "Vaal Orb");
		identifierToCurrencyNameMap.put(17, "Scroll of Wisdom");
		identifierToCurrencyNameMap.put(18, "Portal Scroll");
		identifierToCurrencyNameMap.put(19, "Armourer's Scrap");
		identifierToCurrencyNameMap.put(20, "Blacksmith's Whetstone");
		identifierToCurrencyNameMap.put(21, "Glassblower's Bauble");
		identifierToCurrencyNameMap.put(22, "Orb of Transmutation");
		identifierToCurrencyNameMap.put(23, "Orb of Augmentation");
		identifierToCurrencyNameMap.put(24, "Mirror of Kalandra");
		identifierToCurrencyNameMap.put(25, "Eternal Orb");
		identifierToCurrencyNameMap.put(26, "Perandus Coin");
		identifierToCurrencyNameMap.put(27, "Sacrifice at Dusk");
		identifierToCurrencyNameMap.put(28, "Sacrifice at Midnight");
		identifierToCurrencyNameMap.put(29, "Sacrifice at Dawn");
		identifierToCurrencyNameMap.put(30, "Sacrifice at Noon");
		identifierToCurrencyNameMap.put(31, "Mortal Grief");
		identifierToCurrencyNameMap.put(32, "Mortal Rage");
		identifierToCurrencyNameMap.put(33, "Mortal Hope");
		identifierToCurrencyNameMap.put(34, "Mortal Ignorance");
		identifierToCurrencyNameMap.put(35, "Silver Coin");
		identifierToCurrencyNameMap.put(36, "Eber's Key");
		identifierToCurrencyNameMap.put(37, "Yriel's Key");
		identifierToCurrencyNameMap.put(38, "Inya's Key");
		identifierToCurrencyNameMap.put(39, "Volkuur's Key");
	}
	
	public static String getCurrencyNameFromIdentifier(int identifier) {
		return identifierToCurrencyNameMap.get(identifier);
	}
	
}
