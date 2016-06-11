package com.dmruczek.poe_arbitrage_helper;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.Charsets;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.junit.Before;
import org.junit.Test;

public class ArbitrageOpportunityFinderTest {

	private ArbitrageOpportunityFinder arbitrageOpportunityFinder;
	
	@Before
	public void setUp() {
		arbitrageOpportunityFinder = new ArbitrageOpportunityFinder();
	}
	
	
	private List<CurrencyTradeListing> createWhetstoneTestList() {
		List<CurrencyTradeListing> testList = new ArrayList<CurrencyTradeListing>();
		testList.add(createTestListing("350", 20, "10", 4));
		testList.add(createTestListing("37", 20, "1", 4));
		testList.add(createTestListing("38", 20, "1", 4));
		testList.add(createTestListing("39", 20, "1", 4));
		testList.add(createTestListing("40", 20, "1", 4));
		testList.add(createTestListing("40", 20, "1", 4));
		testList.add(createTestListing("50", 20, "1", 4));
		testList.add(createTestListing("50", 20, "1", 4));
		testList.add(createTestListing("80", 20, "1", 4));
		testList.add(createTestListing("100", 20, "1", 4));
		
		testList.add(createTestListing("1", 4, "25", 20));
		testList.add(createTestListing("1", 4, "23", 20));
		testList.add(createTestListing("1", 4, "23", 20));
		testList.add(createTestListing("1", 4, "23", 20));
		testList.add(createTestListing("1", 4, "23", 20));
		testList.add(createTestListing("1", 4, "20", 20));
		testList.add(createTestListing("1", 4, "15", 20));
		testList.add(createTestListing("1", 4, "10", 20));
		testList.add(createTestListing("1", 4, "1", 20));
		
		return testList;
	}
	
	private CurrencyTradeListing createTestListing(String buyValue, int buyType, String sellValue, int sellType) {
		CurrencyTradeListing listing = new CurrencyTradeListing();
		listing.setBuyOffer(new BigDecimal(buyValue));
		listing.setBuyType(buyType);
		listing.setSellOffer(new BigDecimal(sellValue));
		listing.setSellType(sellType);
		return listing;
	}
	
	
	private static String readFile(String path, Charset encoding) {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, encoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}	
	
	
	
	@Test
	public void testWithWhetstones() {
		arbitrageOpportunityFinder.outputOpportunities(createWhetstoneTestList());
	}
	

	@Test
	public void testWithFullData() throws Exception {
		List<CurrencyTradeListing> listings = getData("src/test/resources/sellChaosTestData.json");
		listings.addAll(getData("src/test/resources/wantChaosTestData.json"));
		arbitrageOpportunityFinder.outputOpportunities(listings);
	}
	
	protected List<CurrencyTradeListing> getData(String path) throws Exception {
		String json = readFile(path, Charsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		Class<?> clz = CurrencyTradeListing.class;
		JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clz);
		List <CurrencyTradeListing> result = mapper.readValue(json, type);
		
		return result;
	}
	
	
}
