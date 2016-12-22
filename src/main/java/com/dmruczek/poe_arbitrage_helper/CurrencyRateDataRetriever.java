package com.dmruczek.poe_arbitrage_helper;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.Charsets;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrencyRateDataRetriever {
	
	private static final String LEAGUE = "Breach";
	
	
	private static final String CURRENCY_TRADE_URL_1 = "http://currency.poe.trade/search?league=" + LEAGUE + "&online=x&want=4&have=";
	private static final String CURRENCY_TRADE_URL_2 = "http://currency.poe.trade/search?league=" + LEAGUE + "&online=x&want=&have=4";
	
	private String retrievalScript;

	public CurrencyRateDataRetriever() {
		retrievalScript = readFile("src/main/resources/currencyTradeListingRetrievalScript.js", Charsets.UTF_8);
	}

	protected static String readFile(String path, Charset encoding) {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, encoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public List<CurrencyTradeListing> retrieveAllCurrencyRates() {
		WebDriver driver = new FirefoxDriver();

		List<CurrencyTradeListing> wantChaos = retrieveCurrencyRatesFromUrl(driver, CURRENCY_TRADE_URL_1);
		List<CurrencyTradeListing> sellChaos = retrieveCurrencyRatesFromUrl(driver, CURRENCY_TRADE_URL_2);
		
		driver.quit();
		
		wantChaos.addAll(sellChaos);
		
		return wantChaos;
	}
	
	protected void openPage(WebDriver driver, String url) {
		driver.get(url);
		
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("div#main")).isDisplayed();
			}
		});
	}
	
	public List<CurrencyTradeListing> retrieveCurrencyRatesFromUrl(WebDriver driver, String url) {

		openPage(driver, url);
		
		@SuppressWarnings("unchecked")
		List<Map<String,String>> data = (List<Map<String,String>>) ((JavascriptExecutor)driver).executeScript(retrievalScript);
		
		List<CurrencyTradeListing> currencyTradeListings = convertRawDataToCurrencyTradeListings(data);
		
//		outputListingsForTesting(currencyTradeListings);
		
		return currencyTradeListings;
	}
	
	protected void outputListingsForTesting(List<CurrencyTradeListing> listings) {
		ObjectMapper om = new ObjectMapper();
		try {
			System.out.println("JSON:\n" + om.writeValueAsString(listings) + "\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	protected List<CurrencyTradeListing> convertRawDataToCurrencyTradeListings(List<Map<String,String>> data) {
		
		List<CurrencyTradeListing> currencyTradeListingList = new ArrayList<CurrencyTradeListing>();
		
		for (Map<String,String> dataMap : data) {
			CurrencyTradeListing listing = new CurrencyTradeListing();
			listing.setBuyOffer(new BigDecimal(dataMap.get("buyValue")));
			listing.setSellOffer(new BigDecimal(dataMap.get("sellValue")));
			listing.setBuyType(Integer.parseInt(dataMap.get("buyCurrency")));
			listing.setSellType(Integer.parseInt(dataMap.get("sellCurrency")));
			currencyTradeListingList.add(listing);
		}

		return currencyTradeListingList;
	}

}
