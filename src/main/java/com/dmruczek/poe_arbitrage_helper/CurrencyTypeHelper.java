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
		identifierToCurrencyNameMap.put(40, "Offering to the Goddess");
		identifierToCurrencyNameMap.put(41, "Fragment of the Hydra");
		identifierToCurrencyNameMap.put(42, "Fragment of the Phoenix");
		identifierToCurrencyNameMap.put(43, "Fragment of the Minotaur");
		identifierToCurrencyNameMap.put(44, "Fragment of the Chimera");
		identifierToCurrencyNameMap.put(45, "Apprentice Cartographer's Sextant");
		identifierToCurrencyNameMap.put(46, "Journeyman Cartographer's Sextant");
		identifierToCurrencyNameMap.put(47, "Master Cartographer's Sextant");
		identifierToCurrencyNameMap.put(48, "Sacrifice Set");
		identifierToCurrencyNameMap.put(49, "Mortal Set");
		identifierToCurrencyNameMap.put(50, "Pale Court Set");
		identifierToCurrencyNameMap.put(51, "Shaper Set");
		identifierToCurrencyNameMap.put(52, "Splinter of Xoph");
		identifierToCurrencyNameMap.put(53, "Splinter of Tul");
		identifierToCurrencyNameMap.put(54, "Splinter of Esh");
		identifierToCurrencyNameMap.put(55, "Splinter of Uul-Netol");
		identifierToCurrencyNameMap.put(56, "Splinter of Chayula");
		identifierToCurrencyNameMap.put(57, "Blessing of Xoph");
		identifierToCurrencyNameMap.put(58, "Blessing of Tul");
		identifierToCurrencyNameMap.put(59, "Blessing of Esh");
		identifierToCurrencyNameMap.put(60, "Blessing of Uul-Netol");
		identifierToCurrencyNameMap.put(61, "Blessing of Chayula");
		identifierToCurrencyNameMap.put(62, "Xoph's Breachstone");
		identifierToCurrencyNameMap.put(63, "Tul's Breachstone");
		identifierToCurrencyNameMap.put(64, "Esh's Breachstone");
		identifierToCurrencyNameMap.put(65, "Uul-Netol's Breachstone");
		identifierToCurrencyNameMap.put(66, "Chayula's Breachstone");
		
	}
	
	public static int getSizeOfCurrencyMap() {
		return identifierToCurrencyNameMap.size();
	}
	
	public static String getCurrencyNameFromIdentifier(int identifier) {
		return identifierToCurrencyNameMap.get(identifier);
	}
	
}
