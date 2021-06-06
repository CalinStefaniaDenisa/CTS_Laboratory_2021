package ro.ase.csie.cts.assignment5.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.csie.cts.assignment5.classes.Product;
import ro.ase.csie.cts.assignment5.exceptions.InexistentWeeklySoldItemsException;
import ro.ase.csie.cts.assignment5.exceptions.SoldItemsLimitsNotRespectedException;
import ro.ase.csie.cts.assignment5.exceptions.WrongNameException;
import ro.ase.csie.cts.assignment5.exceptions.WrongPriceException;
import ro.ase.csie.cts.assignment5.exceptions.WrongSoldItemsException;
import ro.ase.csie.cts.assignment5.tests.categories.ConformanceTests;

public class TestProduct2 {

	static Product product;
	static String initialName;
	static float initialPrice;
	static ArrayList<Integer> weeklySoldItems;
	static ArrayList<Integer> performanceSoldItems;
	static int initialNoWeeks;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initialName = "Laptops";
		initialPrice = Product.MIN_PRICE + 1;
		weeklySoldItems = new ArrayList<>();
		initialNoWeeks = 100;
		Random random = new Random();
		for(int i = 0; i <= initialNoWeeks; i++) {
			weeklySoldItems.add(random.nextInt(Product.MAX_SOLD_ITEMS));
		}
		
		// Performance
		performanceSoldItems = new ArrayList<>();
		for(int i = 0; i <= 1000; i++) {
			performanceSoldItems.add(Product.MAX_SOLD_ITEMS);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		product = new Product(initialName, initialPrice, weeklySoldItems);
	}

	@After
	public void tearDown() throws Exception {
		product = null;
	}

	@Category(ConformanceTests.class)
	@Test
	public void testAddWeekConformanceForRightInput() throws WrongNameException, WrongPriceException, WrongSoldItemsException, InexistentWeeklySoldItemsException {
		ArrayList<Integer> weeklySoldItemsEmpty = new ArrayList<>();
		product = new Product(initialName, initialPrice, weeklySoldItemsEmpty);
		product.addWeek(product.MIN_SOLD_ITEMS + 1);
		
		assertEquals("Testing with a proper sold item", product.MIN_SOLD_ITEMS + 1, product.getSoldItems(0), 0);
	}
	
	@Category(ConformanceTests.class)
	@Test
	public void testGetSoldItemsConformanceForRightInput() throws WrongSoldItemsException, InexistentWeeklySoldItemsException {
		product.setSales(weeklySoldItems);
		weeklySoldItems.add(product.MIN_SOLD_ITEMS + 1);
		product.addWeek(product.MIN_SOLD_ITEMS + 1);
		
		assertEquals("Testing with a proper sold item", product.MIN_SOLD_ITEMS + 1, product.getSoldItems(initialNoWeeks + 1), 0);
	}

	@Category(ConformanceTests.class)
	@Test
	public void testGetNoWeeksAboveLimitConformanceForRightInput() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(9, 10, 150));
		product.setSales(soldItems);
		
		int expectedNoWeeksAboveLimit = 1;
		int computedNoWeeksAboveLimit = product.getNoWeeksAboveLimit(100);
		
		assertEquals("Testing getNoWeeksAboveLimit with proper sold items", expectedNoWeeksAboveLimit, computedNoWeeksAboveLimit, 0);
	}
	
	@Test(expected = WrongSoldItemsException.class)
	public void testAddWeekRangeAboveLimit() throws WrongSoldItemsException {		
		product.addWeek(product.MAX_SOLD_ITEMS + 1);
	}
	
	@Test(expected = InexistentWeeklySoldItemsException.class)
	public void testGetSoldItemsRangeIndexTooHigh() throws InexistentWeeklySoldItemsException {		
		product.getSoldItems(weeklySoldItems.size() + 1);
	}
	
	@Test(expected = SoldItemsLimitsNotRespectedException.class)
	public void testGetNoWeeksAboveLimitRange() throws SoldItemsLimitsNotRespectedException {
		product.getNoWeeksAboveLimit(product.MAX_SOLD_ITEMS + 1);
	}
	
	@Test
	public void testAddWeekLowerBoundary() throws WrongNameException, WrongPriceException, InexistentWeeklySoldItemsException, WrongSoldItemsException {
		ArrayList<Integer> weeklySoldItemsEmpty = new ArrayList<>();
		product = new Product(initialName, initialPrice, weeklySoldItemsEmpty);
		product.addWeek(product.MIN_SOLD_ITEMS);
		
		assertEquals("Testing with lower boundary value as sold item", product.MIN_SOLD_ITEMS, product.getSoldItems(0), 0);
	}
	
	@Test
	public void testAddWeekUpperBoundary() throws WrongNameException, WrongPriceException, WrongSoldItemsException, InexistentWeeklySoldItemsException {
		ArrayList<Integer> weeklySoldItemsEmpty = new ArrayList<>();
		product = new Product(initialName, initialPrice, weeklySoldItemsEmpty);
		product.addWeek(product.MAX_SOLD_ITEMS);
		
		assertEquals("Testing with upper boundary value as sold item", product.MAX_SOLD_ITEMS, product.getSoldItems(0), 0);
	}
	
	@Test
	public void testGetSoldItemsLowerBoundary() throws WrongSoldItemsException, InexistentWeeklySoldItemsException {
		weeklySoldItems.add(product.MIN_SOLD_ITEMS);
		product.addWeek(product.MIN_SOLD_ITEMS);
		
		assertEquals("Testing with lower boundary value as sold item", product.MIN_SOLD_ITEMS, product.getSoldItems(weeklySoldItems.size() - 1), 0);
	}
	
	@Test
	public void testGetSoldItemsUpperBoundary() throws WrongSoldItemsException, InexistentWeeklySoldItemsException {
		weeklySoldItems.add(product.MAX_SOLD_ITEMS);
		product.addWeek(product.MAX_SOLD_ITEMS);
		
		assertEquals("Testing with upper boundary value as sold item", product.MAX_SOLD_ITEMS, product.getSoldItems(weeklySoldItems.size() - 1), 0);
	}
	
	@Test
	public void testGetNoWeeksAboveLimitLowerBoundary() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(9, 10, 150));
		product.setSales(soldItems);
		int expectedNoWeeksAboveLimit = soldItems.size();
		int computedNoWeeksAboveLimit = product.getNoWeeksAboveLimit(product.MIN_SOLD_ITEMS);
		
		assertEquals("Testing with lower boundary value as sold items", expectedNoWeeksAboveLimit, computedNoWeeksAboveLimit, 0);
	}
	
	@Test
	public void testGetNoWeeksAboveLimitUpperBoundary() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(9, 10, 150));
		product.setSales(soldItems);
		int expectedNoWeeksAboveLimit = 0;
		int computedNoWeeksAboveLimit = product.getNoWeeksAboveLimit(product.MAX_SOLD_ITEMS);
		
		assertEquals("Testing with upper boundary value as sold item", expectedNoWeeksAboveLimit, computedNoWeeksAboveLimit, 0);
	}
	
	@Test
	public void testGetNoWeeksAboveLimitCardinalityOne() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(9));
		product.setSales(soldItems);
		int expectedNoWeeksAboveLimit = 1;
		int computedNoWeeksAboveLimit = product.getNoWeeksAboveLimit(product.MIN_SOLD_ITEMS);
		
		assertEquals("Testing with one sold item", expectedNoWeeksAboveLimit, computedNoWeeksAboveLimit, 0);
	}
	
	@Test
	public void testGetNoWeeksAboveLimitCardinalityZero() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		ArrayList<Integer> soldItemsNull =  new ArrayList<>();
		product.setSales(soldItemsNull);
		int expectedNoWeeksAboveLimit = 0;
		int computedNoWeeksAboveLimit = product.getNoWeeksAboveLimit(product.MIN_SOLD_ITEMS);
		
		assertEquals("Testing with no sold item", expectedNoWeeksAboveLimit, computedNoWeeksAboveLimit, 0);
	}
	
	@Test
	public void testGetNoWeeksAboveLimitOrderingAsc() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		ArrayList<Integer> soldItems = new ArrayList<>();
		for(int i = 6 ; i <= 10; i++) {
			soldItems.add(i);
		}
		product.setSales(soldItems);
		int expectedNoWeeksAboveLimit = soldItems.size();
		int computedNoWeeksAboveLimit = product.getNoWeeksAboveLimit(5);
		
		assertEquals("Testing with ascending ordered sold items", expectedNoWeeksAboveLimit, computedNoWeeksAboveLimit, 0);
	}
	
	@Test
	public void testGetNoWeeksAboveLimitOrderingDesc() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		ArrayList<Integer> soldItems = new ArrayList<>();
		for(int i = 10 ; i > 5; i--) {
			soldItems.add(i);
		}
		product.setSales(soldItems);
		int expectedNoWeeksAboveLimit = soldItems.size();
		int computedNoWeeksAboveLimit = product.getNoWeeksAboveLimit(5);
		
		assertEquals("Testing with descending ordered sold items", expectedNoWeeksAboveLimit, computedNoWeeksAboveLimit, 0);
	}
	
	@Test(timeout = 3000)
	public void testGetNoWeeksAboveLimitPerformance() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		product.setSales(performanceSoldItems);
		product.getNoWeeksAboveLimit(product.MIN_SOLD_ITEMS);
	}
	
	@Test
	public void testAddWeekInverse() throws InexistentWeeklySoldItemsException, WrongSoldItemsException {
		product.setSales(performanceSoldItems);
		int initialLastWeek = performanceSoldItems.get(performanceSoldItems.size() - 1);
		int newLastWeek = product.MIN_SOLD_ITEMS;
		product.addWeek(newLastWeek);
		assertNotEquals("addWeek is not adding the week value", initialLastWeek, product.getSoldItems(performanceSoldItems.size()));
	}
	
	@Test
	public void testGetNoWeeksAboveLimitInverse() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		product.setSales(performanceSoldItems);
		int initialNoWeeks = product.getWeeksIndexWithMaxSales().size();
		product.addWeek(product.MAX_SOLD_ITEMS);
		int newNoWeeks = product.getNoWeeksAboveLimit(product.MIN_SOLD_ITEMS);
		assertNotEquals("getNoWeeksAboveLimit is not updating the number of weeks value", initialNoWeeks, newNoWeeks);
	}
	
}
