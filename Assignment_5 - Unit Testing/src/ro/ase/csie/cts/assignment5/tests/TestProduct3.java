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
import ro.ase.csie.cts.assignment5.exceptions.SoldItemsLimitsNotRespectedException;
import ro.ase.csie.cts.assignment5.exceptions.WrongNameException;
import ro.ase.csie.cts.assignment5.exceptions.WrongPriceException;
import ro.ase.csie.cts.assignment5.exceptions.WrongSoldItemsException;
import ro.ase.csie.cts.assignment5.tests.categories.ConformanceTests;

public class TestProduct3 {
	static Product product;
	static String initialName;
	static float initialPrice;
	static ArrayList<Integer> weeklySoldItems;
	static ArrayList<Integer> tooManyWeeklySoldItems;
	static int initialNoWeeks;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initialName = "Laptops";
		initialPrice = Product.MIN_PRICE + 1;
		weeklySoldItems = new ArrayList<>();
		initialNoWeeks = 100;
		Random random = new Random();
		for(int i = 0; i < initialNoWeeks; i++) {
			weeklySoldItems.add(random.nextInt(Product.MAX_SOLD_ITEMS));
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
	public void testGetPercentOfBadWeeksConformanceForRightInput() throws WrongSoldItemsException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(9, 10, 150));
		product.setSales(soldItems);
		
		int expectedPercentOfBadWeeks = 66;
		int computedPercentOfBadWeeks = product.getPercentOfBadWeeks(100);
		
		assertEquals("Testing with proper sold items", expectedPercentOfBadWeeks, computedPercentOfBadWeeks, 0);
	}

	@Category(ConformanceTests.class)
	@Test
	public void testGetWeeksIndexWithMaxSalesConformanceForRightInput() throws WrongSoldItemsException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(9, 10, 150, 150, 150));
		product.setSales(soldItems);
		
		int expectedWeeksIndexWithMaxSales = 3;
		int computedWeeksIndexWithMaxSales = product.getWeeksIndexWithMaxSales().size();
		
		assertEquals("Testing with proper sold items", expectedWeeksIndexWithMaxSales, computedWeeksIndexWithMaxSales, 0);
	}
	
	@Test
	public void testGetPercentOfBadWeeksCrossCheck() throws WrongSoldItemsException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		product.setSales(soldItems);
		int expectedPercentage = 100;
		int computedPercentage = product.getPercentOfBadWeeks(10);
		
		assertEquals("Percentage is not correct", expectedPercentage, computedPercentage);
	}
	
	@Test
	public void testGetWeeksIndexWithMaxSalesCrossCheck() throws WrongSoldItemsException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(10,10,10,10,10,10));
		product.setSales(soldItems);
		int expectedWeeksIndexWithMaxSales = soldItems.size();
		int computedWeeksIndexWithMaxSales = product.getWeeksIndexWithMaxSales().size();
		
		assertEquals("Number of weeks with max sales is not correct", expectedWeeksIndexWithMaxSales, computedWeeksIndexWithMaxSales, 0);
	}

	@Test
	public void testGetPercentOfBadWeeksInverse() throws WrongSoldItemsException {
		ArrayList<Integer> soldItemsInitial = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		product.setSales(soldItemsInitial);
		int initialPercentage = product.getPercentOfBadWeeks(10);
		ArrayList<Integer> soldItemsNew = (ArrayList<Integer>) soldItemsInitial.clone();
		soldItemsNew.add(100);
		product.setSales(soldItemsNew);
		
		assertNotEquals("getPercentOfBadWeeks is not changing the percentage value", initialPercentage, product.getPercentOfBadWeeks(10));
	}
	
	@Test
	public void testGetWeeksIndexWithMaxSalesInverse() throws WrongSoldItemsException {
		ArrayList<Integer> soldItemsInitial = new ArrayList<Integer>(Arrays.asList(10,10,10,10,10,10));
		product.setSales(soldItemsInitial);
		int initialWeeksIndexWithMaxSales = product.getWeeksIndexWithMaxSales().size();
		ArrayList<Integer> soldItemsNew = (ArrayList<Integer>) soldItemsInitial.clone();
		soldItemsNew.add(100);
		product.setSales(soldItemsNew);
		
		assertNotEquals("getWeeksIndexWithMaxSales is not changing its value", initialWeeksIndexWithMaxSales, product.getWeeksIndexWithMaxSales());
	}

	@Test
	public void testGetWeeksIndexWithMaxSalesCardinalityOne() throws WrongSoldItemsException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(9));
		product.setSales(soldItems);
		int expectedWeeksIndexWithMaxSales = 1;
		int computedWeeksIndexWithMaxSales = product.getWeeksIndexWithMaxSales().size();
		
		assertEquals("Testing with one sold item", expectedWeeksIndexWithMaxSales, computedWeeksIndexWithMaxSales, 0);
	}
	
	@Test
	public void testGetWeeksIndexWithMaxSalesCardinalityZero() throws WrongSoldItemsException {
		ArrayList<Integer> soldItemsNull =  new ArrayList<>();
		product.setSales(soldItemsNull);
		int expectedWeeksIndexWithMaxSales = 0;
		int computedWeeksIndexWithMaxSales = product.getWeeksIndexWithMaxSales().size();
		
		assertEquals("Testing with no sold item", expectedWeeksIndexWithMaxSales, computedWeeksIndexWithMaxSales, 0);
	}
	
	@Test
	public void testGetPercentOfBadWeeksCardinalityOne() throws WrongSoldItemsException, SoldItemsLimitsNotRespectedException {
		ArrayList<Integer> soldItems = new ArrayList<Integer>(Arrays.asList(9));
		product.setSales(soldItems);
		int expectedPercentage = 100;
		int computedPercentage = product.getPercentOfBadWeeks(product.MAX_SOLD_ITEMS);
		
		assertEquals("Testing with one sold item", expectedPercentage, computedPercentage, 0);
	}
	
	@Test
	public void testGetPercentOfBadWeeksCardinalityZero() throws WrongSoldItemsException {
		ArrayList<Integer> soldItemsNull =  new ArrayList<>();
		product.setSales(soldItemsNull);
		int expectedPercentage = 0;
		int computedPercentage = product.getPercentOfBadWeeks(product.MAX_SOLD_ITEMS);
		
		assertEquals("Testing with no sold item", expectedPercentage, computedPercentage, 0);
	}

}
